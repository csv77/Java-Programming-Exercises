package randomcirclepoints;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class RandomCirclePoints extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        Circle c1 = new Circle(100, 100, 50);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);
        pane.getChildren().add(c1);
        
        Polygon p1 = new Polygon();
        ObservableList<Double> list = p1.getPoints();
        p1.setStroke(Color.BLACK);
        p1.setFill(Color.WHITE);
        pane.getChildren().add(p1);
        
        ArrayList<Double> angles = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            double angle = Math.random() * (2 * Math.PI);
            if(!angles.contains(angle)) {
                angles.add(angle);
            }
        }
        Collections.sort(angles);
        
        for(int i = 0; i < angles.size(); i++) {
            list.add(c1.getCenterX() + c1.getRadius() * Math.cos(angles.get(i)));
            list.add(c1.getCenterY() - c1.getRadius() * Math.sin(angles.get(i)));
        }
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Points on a circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
