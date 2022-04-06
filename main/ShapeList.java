package main;
import java.util.*;
import main.Shapes.*;

public class ShapeList {
    private static List<Shape> shapeList = new ArrayList<>(Arrays.asList(
        new Sphere(new Vector3(1, 1, 5), 0.5, 0, new Color(255, 0, 0, 255)),
        new Sphere(new Vector3(2, 2, 4), 0.55, 0, new Color(255, 0, 255, 255)),
        new Sphere(new Vector3(3, 2, 4.3), 0.8, 0, new Color(255, 0, 25, 25))
        
        ));

    public static List<Shape> shapes(){
        return shapeList;
    }

    public static List<Shape> shapeAnim1(){
        Vector3 changePos = shapeList.get(1).position().add(Vector3.I_VECTOR3.times(0.05));
        changePos = changePos.add(new Vector3(0, 0, 0.01));
        shapeList.get(1).setPosition(changePos);
        return shapeList;
    }

}
