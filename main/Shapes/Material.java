package main.Shapes;

public class Material {
    //maybe making this between zero and one could help
    private double diffuseConstant, ambientConstant, specularConstant;
    private int shininess;

    public Material(double ambientConstant, double diffuseConstant, double specularConstant, int shininess){
        this.ambientConstant = ambientConstant;
        this.diffuseConstant = diffuseConstant;
        this.specularConstant = specularConstant;
        this.shininess = shininess;
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

    public int shininess(){
        return shininess;
    }
}
