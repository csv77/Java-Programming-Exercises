package exercise_16_25;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CarPane extends Pane{
    private Timeline racing;
    private Rectangle rec;
    private Polygon trapeze;
    private Circle c1, c2;
    private double dx = 1.0;
    private ObservableList<Double> points;
    
    public CarPane(double x, double y) {
        drawCar(x, y);
        racing = new Timeline(new KeyFrame(Duration.millis(200), e -> {
            drive(x, y);
        }));
        racing.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void play() {
        racing.play();
    }
    
    public void stop() {
        racing.stop();
    }
    
    public void pause() {
        racing.pause();
    }
    
    public void increaseSpeed() {
        racing.setRate(racing.getRate() + 0.1);
    }
    
    public void decreaseSpeed() {
        racing.setRate(racing.getRate() - 0.1);
    }
    
    public void setSpeed(double speed) {
        if(speed <= 100) {
            racing.setRate(speed);
        }
        else {
            racing.setRate(0);
        }
    }
    
    public void drive(double x, double y) {
        points = trapeze.getPoints();
        if(rec.getX() < getWidth()) {
            for(int i = 0; i < points.size(); i += 2) {
                points.set(i, points.get(i) + dx);
            }
            rec.setX(rec.getX() + dx);
            c1.setCenterX(c1.getCenterX() + dx);
            c2.setCenterX(c2.getCenterX() + dx);
        }
        else {
            drawCar(x, y);
        }
    }
    
    public void drawCar(double x, double y) {
        rec = new Rectangle(x, y - 20, 50, 10);
        rec.setFill(Color.CYAN);
        c1 = new Circle(x + 15, y - 5, 5);
        c2 = new Circle(x + 35, y - 5, 5);
        trapeze = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        trapeze.setFill(Color.LIGHTSKYBLUE);
        getChildren().addAll(rec, c1, c2, trapeze);
    }
    
    
}
