package exercise_20_05;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private double dx = 1;
    private double dy = 1;

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
    
    Ball(double x, double y, double radius, Color color) {
        super(x, y, radius);
        setFill(color);
    }
}
