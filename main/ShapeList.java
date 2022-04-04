package main;
import java.util.*;
import main.Shapes.*;

public class ShapeList {
    private static List<Shape> shapeList = new ArrayList<>(Arrays.asList(
        new Sphere(new Vector3(5, 5, 5), 0, new Color(255, 0, 0, 255)))
        );

    public static List<Shape> shapes(){
        return shapeList;
    }

}
