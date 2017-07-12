package exercise_20_09;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle implements Comparable<Ball> {
    private double dx = 1;
    private double dy = 1;
    private Color color;
    
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Ball(double x, double y, double radius, Color color) {
        super(x, y, radius);
        setColor(color);
        setFill(color);
    }

    @Override
    public int compareTo(Ball o) {
        if(getRadius() > o.getRadius()) {
            return 1;
        }
        else if(getRadius() == o.getRadius()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
