package main.Shapes;
import main.Vector3;

public interface Shape {
    Vector3 position();
    double reflectance();
    int color();
}
