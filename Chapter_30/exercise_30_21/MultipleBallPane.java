package exercise_30_21;

import exercise_20_05.Ball;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MultipleBallPane extends Pane {
    private int sleepTime;
    private Thread thread = new Thread(() -> {
       try {
            while(true) {
                Platform.runLater(() -> moveBall());
                Thread.sleep(sleepTime);
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        } 
    });
    
    public MultipleBallPane() {
        sleepTime = 10;
        thread.start();
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }
    
    public void add() {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        Ball ball = new Ball(30, 30, 20, color);
        getChildren().add(ball);
        ball.setOnMousePressed(e -> getChildren().remove(ball));
    }
    
    public void add(Ball ball) {
        ball.setOnMousePressed(e -> getChildren().remove(ball));
        getChildren().add(ball);
    }
    
    public void subtract() {
        if(getChildren().size() > 0) {
            getChildren().remove(getChildren().size() - 1);
        }
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
        for(int i = 0; i < getChildren().size(); i++) {
            Ball ball = (Ball)getChildren().get(i);
            if(ball.getCenterX() > getWidth() - ball.getRadius() ||
                    ball.getCenterX() < ball.getRadius()) {
                ball.setDx(ball.getDx() * (- 1));
            }
            if(ball.getCenterY() > getHeight() - ball.getRadius() ||
                    ball.getCenterY() < ball.getRadius()) {
                ball.setDy(ball.getDy() * (- 1));
            }
            
            ball.setCenterX(ball.getCenterX() + ball.getDx());
            ball.setCenterY(ball.getCenterY() + ball.getDy());
            
            for(int j = i + 1; j < getChildren().size(); j++) {
                Ball ball2 = (Ball)getChildren().get(j);
                if(isIntersect(ball, ball2)) {
                    double radius = ball.getRadius() + ball2.getRadius();
                    double centerX;
                    double centerY;
                    
                    if(ball.getCenterX() - radius < 0) {
                        centerX = radius;
                    }
                    else if(ball.getCenterX() > getWidth() - radius){
                        centerX = getWidth() - radius;
                    }
                    else {
                        centerX = ball.getCenterX();
                    }
                    
                    if(ball.getCenterY() - radius < 0) {
                        centerY = radius;
                    }
                    else if(ball.getCenterY() > getHeight()- radius){
                        centerY = getHeight()- radius;
                    }
                    else {
                        centerY = ball.getCenterY();
                    }
                    
                    Ball newBall = new Ball(centerX, centerY, radius, ball.getColor());
                    getChildren().removeAll(ball, ball2);
                    add(newBall);
                }
            }
        }
    }
    
    protected boolean isIntersect(Ball b1, Ball b2) {
        if(Math.abs(b1.getCenterX() - b2.getCenterX()) <= b1.getRadius() + b2.getRadius() &&
                Math.abs(b1.getCenterY() - b2.getCenterY()) <= b1.getRadius() + b2.getRadius()) {
            return true;
        }
        else {
            return false;
        }
    }
}
