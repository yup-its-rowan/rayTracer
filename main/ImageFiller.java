package main;
import java.awt.image.BufferedImage;
import java.util.*;
import main.Shapes.*;

public class ImageFiller {

    private static Vector3 orthoDirection = new Vector3(0, 0, 1);

    public static void fill(Main.Camera cameraState, Main.Shader shaderState, BufferedImage image, Color background, List<Shape> shapes, List<Light> lights){
        for (int i= 0; i < Main.displayWidth; i++){
            for (int j = 0; j < Main.displayHeight; j++){
                image.setRGB(i, Main.displayHeight-j-1, background.argb());
            }
        }
        //i know i can make the code shorter but i would hate to debug it if things went wrong

        for (double i= 0; i < Main.displayWidth; i ++){
            for (double j = 0; j < Main.displayHeight; j++){
                Vector3 pixelPos = new Vector3(Main.widRat*(i+0.5) + Main.cameraPosition.getValues()[0], 
                Main.heiRat*(j+0.5) + Main.cameraPosition.getValues()[1], 
                Main.cameraPosition.getValues()[2]);

                Vector3 directionVec;
                switch (cameraState){
                    case JustBackground:
                        return;
                    case Orthographic:
                        directionVec = orthoDirection;
                        break;
                    case Perspective:
                        directionVec = (pixelPos.subtract(Main.focalPosition)).normalized();
                        break;
                    default:
                        directionVec = orthoDirection;
                }
                
                Integer color = rayCast(
                    pixelPos, directionVec, shaderState, shapes, lights);
                if (color != null){
                    image.setRGB((int)i, (int)(Main.displayHeight - j-1), color);
                }
            }
        }
    }

    //should return the color the pixel should be
    private static Integer rayCast(Vector3 origin, Vector3 direction, Main.Shader shaderState, List<Shape> shapes, List<Light> lights){
        //Color pixelColor;
        //System.out.println(Arrays.toString(origin.getValues()));
        Shape nearestShape = null;
        double closestScalar = Double.POSITIVE_INFINITY;
        for (Shape shape : shapes){
            double closestScalarTemp = shape.closestScalar(origin, direction);
            if (closestScalarTemp != -1 && closestScalarTemp < closestScalar){
                closestScalar = closestScalarTemp;
                nearestShape = shape;
            }
        }
        //make sure to call to different methods for each Phong case, so it's easier to calculate Phong separately.
        //need to move the multiplication by constant out of the for loops. might be a ceiling problem though
        //need to fix phong by combining specular and diffusion
        
        switch (shaderState){
            case Original:
                if (nearestShape != null){
                    return nearestShape.getColor().argb();
                }
                break;
            case Ambient:
                if (nearestShape != null){
                    return ambientCalculator(nearestShape).argb();
                }
                break;
            case Diffusion:
                if (nearestShape != null){
                    Color temp = Color.Black;
                    for (Light light : lights){
                        if (doesLightShine(light, nearestShape, shapes)){
                            temp = temp.add(diffuseCalculator(nearestShape, light, origin.add(direction.times(closestScalar))));
                        }
                    }
                    return temp.argb();
                }
                break;
            case Specular:
                if (nearestShape != null){
                    Color temp = Color.Black;
                    for (Light light : lights){
                        if (doesLightShine(light, nearestShape, shapes)){
                            temp = temp.add(specularCalculator(nearestShape, light, origin.add(direction.times(closestScalar))));
                        }
                    }
                    return temp.argb();
                }
                break;
            case Phong:
                if (nearestShape != null){
                    Color temp = Color.Black;
                    for (Light light : lights){
                        if (doesLightShine(light, nearestShape, shapes)){
                            temp = temp.add(diffuseCalculator(nearestShape, light, origin.add(direction.times(closestScalar))));
                            temp = temp.add(specularCalculator(nearestShape, light, origin.add(direction.times(closestScalar))));
                        }
                    }
                    temp = temp.add(ambientCalculator(nearestShape));
                    return temp.argb();
                }
                break;
            default:
                return null;
        }
        return null;
    }

    private static Color ambientCalculator(Shape shape){
        return shape.getColor().times(shape.material().kA());
    }

    private static Color diffuseCalculator(Shape shape, Light light, Vector3 point){   
        return shape.getColor().times(((light.pos().subtract(point)).normalized()).dotProduct(shape.normal(point))*shape.material().kD());
    }

    private static Color specularCalculator(Shape shape, Light light, Vector3 point){
        Vector3 normalizedLight = (light.pos().subtract(point)).normalized();
        Vector3 normalizedNormal = shape.normal(point);
        //Vector3 r = ((normalizedNormal.times(2*(normalizedLight.dotProduct(normalizedNormal)))).subtract(normalizedLight)).normalized();
        //Vector3 v = (Main.focalPosition.subtract(point)).normalized();
        //double variables = Math.pow(Math.max(v.dotProduct(r),0), shape.material().shininess()) * shape.material().kS();
        //return shape.getColor().times(variables);
        return shape.getColor().times(shape.material().kS()*Math.pow(Math.max((((normalizedNormal.times(2*normalizedLight.dotProduct(normalizedNormal))).subtract(normalizedLight)).normalized()).dotProduct(((Main.focalPosition.subtract(point)).normalized())), 0), shape.material().shininess()));
    }

    private static boolean doesLightShine(Light light, Shape shape, List<Shape> shapes){
        return true;
    }
}
