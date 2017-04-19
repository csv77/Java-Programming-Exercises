package pendulum;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class PendulumPane extends Pane{
    private Arc a;
    private double w;
    private double h;
    private Circle c1;
    private Circle c2;
    private Line line;
    private PathTransition pt;
    
    public PendulumPane(double width, double height) {
        w = width;
        h = height;
        setPrefWidth(width);
        setPrefHeight(height);
        a = new Arc(w * 0.5, h * 0.1, w * 0.3, w * 0.3, 240, 60);
        a.setFill(Color.TRANSPARENT);
        getChildren().add(a);
        drawPendulum(a);
        pt = new PathTransition(Duration.millis(1000), a, c2);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
    }
    
    public void play() {
        pt.play();
    }
    
    public void pause() {
        pt.pause();
    }
    
    public void increaseSpeed() {
        pt.setRate(pt.getRate() + 0.1);
    }
    
    public void decreaseSpeed() {
        pt.setRate(pt.getRate() - 0.1);
    }
    
    public void drawPendulum(Arc a) {
        c1 = new Circle(a.getCenterX(), a.getCenterY(), 5);
        c2 = new Circle(a.getCenterX() - a.getRadiusX() * Math.cos(Math.PI / 3), a.getCenterY() + a.getRadiusY() * Math.sin(Math.PI / 3), 10);
        line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        line.endXProperty().bind(c2.translateXProperty().add(c2.centerXProperty()));
        line.endYProperty().bind(c2.translateYProperty().add(c2.centerYProperty()));
        line.setStroke(Color.BLACK);
        getChildren().addAll(c1, c2, line);
    }
    
}
