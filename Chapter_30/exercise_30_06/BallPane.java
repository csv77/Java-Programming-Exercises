package exercise_30_06;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private int sleepTime = 10;
    private Thread thread = new Thread(() -> {
        try {
            while(true) {
                Platform.runLater(() -> moveBall());
                Thread.sleep(sleepTime);
            }
        }
        catch (InterruptedException ex) {
        }
    });

    public BallPane() {
        circle.setFill(Color.GREEN);
        getChildren().add(circle);
        thread.start();
    }

    public void resume() {
        thread.resume();
    }

    public void suspend() {
        thread.suspend();
    }

    public void increaseSpeed() {
        if(sleepTime > 1) {
            sleepTime--;
        }
    }

    public void decreaseSpeed() {
        sleepTime++;
    }

    protected void moveBall() {
        if(x < radius || x > getWidth() - radius) {
            dx *= -1;
        }
        if(y < radius || y > getHeight() - radius) {
            dy *= -1;
        }

        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}