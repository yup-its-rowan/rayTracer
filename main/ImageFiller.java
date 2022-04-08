package main;
import java.awt.image.BufferedImage;
import java.util.*;
import main.Shapes.Shape;

public class ImageFiller {

    private static Vector3 orthoDirection = new Vector3(0, 0, 1);

    public static void fill(Main.Camera cameraState, Main.Shader shaderState, BufferedImage image, Color background, List<Shape> shapes){
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
                        directionVec = pixelPos.subtract(Main.focalPosition);
                        break;
                    default:
                        directionVec = orthoDirection;
                }
                
                Integer color = rayCast(
                    pixelPos, directionVec, shaderState, shapes);
                if (color != null){
                    image.setRGB((int)i, (int)(Main.displayHeight - j-1), color);
                }
            }
        }
    }

    //should return the color the pixel should be
    public static Integer rayCast(Vector3 origin, Vector3 direction, Main.Shader shaderState, List<Shape> shapes){
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
        switch (shaderState){
            case Original:
                if (nearestShape != null){
                    return nearestShape.color();
                }
                break;
            case Ambient:
                break;
            case Diffusion:
                break;
            case Specular:
                break;
            case Phong:
                break;
            default:
                return null;
        }
        return null;
    }
}
