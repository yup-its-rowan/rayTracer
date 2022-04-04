package main;
import java.awt.image.BufferedImage;
import java.util.*;
import main.Shapes.Shape;

public class ImageFiller {

    public static void fill(Main.Camera cameraState, BufferedImage image, Color background, List<Shape> shapes){
        for (int i= 0; i < Main.width; i ++){
            for (int j = 0; j < Main.height; j++){
                image.setRGB(i, j, background.argb());
            }
        }
        switch(cameraState){
            case JustBackground:
                break;
            case Orthographic:
                break;
            case Perspective:
                break;
        }
    }
}
