package movablecirclesanddistances;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MovableCirclesAndDistances extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Circle c1 = new Circle(40, 40, 10);
        setProperties(c1);
        Circle c2 = new Circle(120, 150, 10);
        setProperties(c2);
        pane.getChildren().addAll(getLine(c1, c2), getText(c1, c2), c1, c2);
        
        pane.setOnMouseDragged(e -> {
            if(c1.contains(e.getX(), e.getY())){
                pane.getChildren().clear();
                c1.setCenterX(e.getX());
                c1.setCenterY(e.getY());
                pane.getChildren().addAll(getLine(c1, c2), getText(c1, c2), c1, c2);
            }
            else if(c2.contains(e.getX(), e.getY())) {
                pane.getChildren().clear();
                c2.setCenterX(e.getX());
                c2.setCenterY(e.getY());
                pane.getChildren().addAll(getLine(c1, c2), getText(c1, c2), c1, c2);
            }
        });
        
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Movable circles and distances");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void setProperties(Circle c) {
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
    }
    
    public double getDistance(Circle c1, Circle c2) {
        return(Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(), 2) + Math.pow(c1.getCenterY() - c2.getCenterY(), 2)) -
                c1.getRadius() - c2.getRadius());
    }
    
    public Line getLine(Circle c1, Circle c2) {
        return new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
    }
    
    public Text getText(Circle c1, Circle c2) {
        return new Text((c1.getCenterX() + c2.getCenterX()) / 2, (c1.getCenterY() + c2.getCenterY()) / 2,
                String.format("%.2f", getDistance(c1, c2)));
    }
    
}
