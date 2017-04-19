package movetheball;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
    Circle circle = new  Circle(20, 20, 20);
    
    public BallPane() {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
    }
    
    public void left() {
        circle.setCenterX(circle.getCenterX() > circle.getRadius() ?
                circle.getCenterX() - 20 : circle.getCenterX());
        circle.setCenterY(circle.getCenterY());
    }
    
    public void right() {
        circle.setCenterX(circle.getCenterX() < getWidth() - circle.getRadius() ?
                circle.getCenterX() + 20 : circle.getCenterX());
        circle.setCenterY(circle.getCenterY());
    }
    
    public void up() {
        circle.setCenterY(circle.getCenterY() > circle.getRadius() ?
                circle.getCenterY() - 20 : circle.getCenterY());
        circle.setCenterX(circle.getCenterX());
    }
    
    public void down() {
        circle.setCenterY(circle.getCenterY() < getHeight() - circle.getRadius() ?
                circle.getCenterY() + 20 : circle.getCenterY());
        circle.setCenterX(circle.getCenterX());
    }
}
