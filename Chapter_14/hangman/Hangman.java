package hangman;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Hangman extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Polyline p1 = new Polyline();
        p1.setStroke(Color.BLACK);
        ObservableList<Double> list1 = p1.getPoints();
        double x1 = 40;
        double x3 = 140;
        double y1 = 190;
        double y2 = 20;
        list1.addAll(x1, y1, x1, y2, x3, y2, x3, y1 * 0.6);
        
        Polyline p2 = new Polyline();
        p2.setStroke(Color.BLACK);
        ObservableList<Double> list2 = p2.getPoints();
        list2.addAll((x1 + x3) * 0.5, y1 * 0.5, x3, y1 * 0.25, x3 + (x3 - x1) * 0.5, y1 * 0.5);
        
        Polyline p3 = new Polyline();
        p2.setStroke(Color.BLACK);
        ObservableList<Double> list3 = p3.getPoints();
        list3.addAll((x1 + x3) * 0.6, y1 * 0.75, x3, y1 * 0.6, x3 + (x3 - x1) * 0.3, y1 * 0.75);
        
        Circle c = new Circle(x3, y1 * 0.25, 15);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        
        Arc a = new Arc(x1, y1 + 1, 25, 10, 0, 180);
        a.setStroke(Color.BLACK);
        a.setFill(Color.WHITE);
        
        pane.getChildren().addAll(p1, p2, p3, c, a);
        Scene scene = new Scene(pane, 200, 200);
        
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
