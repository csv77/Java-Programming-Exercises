package exercise_20_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MultipleBallPane extends Pane {
    private Timeline animation;
    private PriorityQueue<Ball> balls = new PriorityQueue(new BallComparator().reversed());
    
    public MultipleBallPane() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    
    public void add() {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        Ball ball = new Ball(30, 30, (int)(Math.random() * 19) + 2, color);
        getChildren().add(ball);
        balls.offer(ball);
    }
    
    public void subtract() {
        if(getChildren().size() > 0) {
            getChildren().remove(balls.poll());
        }
    }
    
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }
    
    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }
    
    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }
    
    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }
    
    protected void moveBall() {
        for(Node nodes : getChildren()) {
            Ball ball = (Ball)nodes;
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
        }
    }
}
