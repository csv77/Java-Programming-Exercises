package displaybeanmachine;

import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class DisplayBeanMachine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(20, 40, 20, 80));
        
        Polyline p = new Polyline();
        pane.getChildren().add(p);
        p.setFill(Color.WHITE);
        ObservableList<Double> list = p.getPoints();
        double firstX = 240;
        double firstY = 60;
        double thirdX = 100;
        double thirdY = 380;
        double[] points = {firstX, firstY, firstX, firstY + 40, thirdX, thirdY, thirdX, thirdY + 80,
            thirdX + 320, thirdY + 80, thirdX + 320, thirdY, firstX + 40, firstY + 40, firstX + 40, firstY};
        for(int i = 0; i < points.length; i++) {
            list.add(points[i]);
        }
        
        getLines(pane, thirdX, thirdY);
        getCircles(pane);
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Bean Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void getCircles(Pane pane) {
        double x = 0, y = 0;
        for(int j = 7; j > 0; j--) {
            for(int i = 1; i < j + 1; i++) {
                Circle c = new Circle(100 + 40 * i + 20 * x, 380 - 10 - 40 * y, 10);
                c.setFill(Color.RED);
                c.setStroke(Color.RED);
                pane.getChildren().add(c);
            }
            x++;
            y++;
        }
    }
    
    public static void getLines(Pane pane, double thirdX, double thirdY) {
        for(int i = 1; i < 8; i++) {
            Line line = new Line(thirdX + 40 * i, thirdY, thirdX + 40 * i, thirdY + 80);
            pane.getChildren().add(line);
        }
    }
    
}
