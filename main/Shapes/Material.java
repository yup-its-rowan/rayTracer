package main.Shapes;

public class Material {

    private double diffuseConstant, ambientConstant, specularConstant;

    public Material(double ambientConstant, double diffuseConstant, double specularConstant){
        this.ambientConstant = ambientConstant;
        this.diffuseConstant = diffuseConstant;
        this.specularConstant = specularConstant;
    }

    public double kD(){
        return diffuseConstant;
    }

    public double kA(){
        return ambientConstant;
    }

    public double kS(){
        return specularConstant;
    }
}
