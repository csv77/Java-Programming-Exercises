package runningfan;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class FanPane extends Pane {
    private Timeline animation;
    private double rotationAngle = 1;
    private Arc[] arcs = new Arc[4];
    private Circle c;
    
    public FanPane(double paneWidht, double paneHeight, double radius) {
        c = new Circle(paneWidht * 0.5, paneHeight * 0.5, radius);
        c.setStroke(Color.BLACK);
        c.setFill(Color.TRANSPARENT);
        double angle = 40;
        for(int i = 0; i < arcs.length; i++) {
            arcs[i] = new Arc(c.getCenterX(), c.getCenterY(), c.getRadius() * 0.9, c.getRadius() * 0.9, 15 + i * 90, angle);
            arcs[i].setType(ArcType.ROUND);
            arcs[i].setFill(Color.RED);
        }
        getChildren().add(c);
        getChildren().addAll(arcs);
        animation = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            spin();
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void spin() {
        for(int i = 0; i < arcs.length; i++) {
            arcs[i].setStartAngle(arcs[i].getStartAngle() + rotationAngle);
        }
    }
    
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }
    
    public void reverse() {
        rotationAngle *= -1;
    }
    
    public DoubleProperty getRateProperty() {
        return animation.rateProperty();
    }
    
    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }
    
    public void decreaseSpeed() {
        animation.setRate(animation.getRate() - 0.1);
    }

}
