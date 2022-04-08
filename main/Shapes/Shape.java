package main.Shapes;
import main.Vector3;

public interface Shape {
    Vector3 position();
    Material material();
    int color();
    double closestScalar(Vector3 o, Vector3 d);
    void setPosition(Vector3 pos);
}
