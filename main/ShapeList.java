package main;
import java.util.*;
import main.Shapes.*;

public class ShapeList {
    //ambient, diffuse, specular
    public static Material mat = new Material(0.2, 0.5, 0.7, 30);
    private static List<Shape> shapeList = new ArrayList<>(Arrays.asList(
        new Sphere(new Vector3(1, 1, 3), 0.5, mat, new Color(0, 0, 255)),
        new Sphere(new Vector3(2, 2, 4), 0.55, mat, new Color(0, 255, 255)),
        new Sphere(new Vector3(3, 2, 4.3), 0.7, mat, new Color(0, 50, 50))
        
    ));

    private static List<Light> lightList = new ArrayList<>(Arrays.asList(
        new Light(2.5,0,1)
    

    )){};

    public static List<Shape> shapes(){
        return shapeList;
    }

    public static List<Light> lights(){
        return lightList;
    }

    public static List<Shape> shapeAnim1(){
        Vector3 changePos = shapeList.get(1).position().add(Vector3.I_VECTOR3.times(0.05));
        changePos = changePos.add(new Vector3(0, 0, 0));
        shapeList.get(1).setPosition(changePos);
        return shapeList;
    }

}
