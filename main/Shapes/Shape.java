package main.Shapes;
import main.*;

public interface Shape {
    Vector3 position();
    Material material();
    double closestScalar(Vector3 o, Vector3 d);
    void setPosition(Vector3 pos);
    Color getColor();
    Vector3 normal(Vector3 pos);
}
