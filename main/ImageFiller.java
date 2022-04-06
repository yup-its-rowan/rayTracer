package main;
import java.awt.image.BufferedImage;
import java.util.*;
import main.Shapes.Shape;

public class ImageFiller {

    private static Vector3 orthoDirection = new Vector3(0, 0, 1);

    public static void fill(Main.Camera cameraState, BufferedImage image, Color background, List<Shape> shapes){
        for (int i= 0; i < Main.displayWidth; i ++){
            for (int j = 0; j < Main.displayHeight; j++){
                image.setRGB(i, j, background.argb());
            }
        }
        switch(cameraState){
            case JustBackground:
                break;
            case Orthographic:
                //i and j are doubles because there might be a problem adding 0.5 to them before getting the sample point and for the love of god i would like to be careful
                for (double i= 0; i < Main.displayWidth; i ++){
                    for (double j = 0; j < Main.displayHeight; j++){
                        Integer color = rayCast(
                            new Vector3(Main.widRat*(i+0.5) + Main.cameraPosition.getValues()[0], 
                            Main.heiRat*(j+0.5) + Main.cameraPosition.getValues()[1], 
                            Main.cameraPosition.getValues()[2]), orthoDirection, shapes);
                        if (color != null){
                            image.setRGB((int)i, (int)j, color);
                        }
                    }
                }
                break;
            case Perspective:
                break;
        }
    }

    //should return the color the pixel should be
    public static Integer rayCast(Vector3 origin, Vector3 direction, List<Shape> shapes){
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
        if (nearestShape != null){
            //System.out.println("got here");
            return nearestShape.color();
        } else {
            return null;
        }
    }
}
