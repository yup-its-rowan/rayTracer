package main.Shapes;

import main.Vector3;

public class Light {
    private Vector3 position;
    
    public Light(Vector3 v){
        position = v;
    }

    public Light(double a, double b, double c){
        position = new Vector3(a, b, c);
    }

    public Vector3 pos(){
        return position;
    }
}
