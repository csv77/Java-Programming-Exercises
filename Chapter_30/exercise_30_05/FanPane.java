package exercise_30_05;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class FanPane extends Pane {
    private double rotationAngle = 1;
    private Arc[] arcs = new Arc[4];
    private Circle c;
    private int sleepTime = 10;
    private Thread thread = new Thread(() -> {
        try {
            while(true) {
                Platform.runLater(() -> spin());
                Thread.sleep(sleepTime);
            }
        }
        catch (InterruptedException ex) {
        }
    });
    
    public FanPane(double paneWidth, double paneHeight, double radius) {
        c = new Circle(paneWidth * 0.5, paneHeight * 0.5, radius);
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
        thread.start();
    }
    
    public void spin() {
        for(int i = 0; i < arcs.length; i++) {
            arcs[i].setStartAngle(arcs[i].getStartAngle() + rotationAngle);
        }
    }
    
    public void resume() {
        thread.resume();
    }
    
    public void suspend() {
        thread.suspend();
    }
    
    public void reverse() {
        rotationAngle *= -1;
    }
    
    public void increaseSpeed() {
        if(sleepTime > 1) {
            sleepTime--;
        }
    }
    
    public void decreaseSpeed() {
        sleepTime++;
    }
}
