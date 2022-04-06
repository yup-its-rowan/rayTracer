package main.Shapes;
import main.*;

public class Sphere implements Shape{
    private Vector3 position;
    private double reflectance;
    private int color;
    private double radius;

    public Sphere(Vector3 pos, double rad, double ref, Color col){
        position = pos;
        reflectance = ref;
        color = col.argb();
        radius = rad;
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
        return color;
    }

    public double radius(){
        return radius;
    }

    @Override
    public double closestScalar(Vector3 o1, Vector3 v) {
        Vector3 o = o1.subtract(position);
        double a = v.dotProduct(v);
        double b = 2*o.dotProduct(v);
        double c = o.dotProduct(o) - Math.pow(radius, 2);
        double disc = Math.pow(b, 2) -4*a*c;
        if (disc < 0){
            //System.out.println("impossible discriminant " + radius);
            return -1;
        }

        double y = (-b + Math.sqrt(disc))/(2*a);
        double z = (-b - Math.sqrt(disc))/(2*a);

        if (y > 0 && z > 0){
            return Math.min(y, z);
        } else if (y > 0){
            return y;
        } else if (z > 0){
            return z;
        }
        //System.out.println("no solution");
        return -1;
    }

    @Override
    public void setPosition(Vector3 pos) {
        position = pos;
    }

}
