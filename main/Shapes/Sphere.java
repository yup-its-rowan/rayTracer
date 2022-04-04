package main.Shapes;
import main.Color;
import main.Vector3;

public class Sphere implements Shape{
    private Vector3 position;
    private double reflectance;
    private int color;

    public Sphere(Vector3 pos, double ref, Color col){
        position = pos;
        reflectance = ref;
        color = col.argb();
    }

    @Override
    public Vector3 position(){
        return position.clone();
    }

    @Override
    public double reflectance() {
        return reflectance;
    }

    @Override
    public int color() {
        // TODO Auto-generated method stub
        return color;
    }
}
