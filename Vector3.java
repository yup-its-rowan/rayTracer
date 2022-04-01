import java.lang.Math;

public class Vector3{

    private double[] values = new double[3];

    public Vector3(double a, double b, double c){
        values[0] = a;
        values[1] = b;
        values[2] = c;
    }

    public Vector3(double[] valuess){
        this.values = valuess;
    }

    public double[] getValues(){
        return values.clone();
    }

    public Vector3 add(Vector3 v){
        return new Vector3(new double[]{values[0]+v.getValues()[0], values[1]+v.getValues()[1], values[2]+v.getValues()[2]});
    }

    public Vector3 add(double a, double b, double c){
        return add(new Vector3(a, b, c));
    }

    public Vector3 subtract(Vector3 v){
        return new Vector3(new double[]{values[0]-v.getValues()[0], values[1]-v.getValues()[1], values[2]-v.getValues()[2]});
    }

    public Vector3 subtract(double a, double b, double c){
        return subtract(new Vector3(a, b, c));
    }

    public double dotProduct(Vector3 v){
        return values[0]*v.getValues()[0] + values[1]*v.getValues()[1] + values[2]*v.getValues()[2];
    }

    public double dotProduct(double a, double b, double c){
        return dotProduct(new Vector3(a, b, c));
    }

    public Vector3 times(double d){
        return new Vector3(values[0]*d, values[1]*d, values[2]*d);
    }

    public Vector3 normalized(){{
        double totalLength =  Math.sqrt(dotProduct(this));
        return new Vector3(values[0]/totalLength, values[1]/totalLength, values[2]/totalLength);
    }}
}