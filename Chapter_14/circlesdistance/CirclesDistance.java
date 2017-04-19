package circlesdistance;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CirclesDistance extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        double centerX1 = Math.random() * 180 + 10;
        double centerY1 = Math.random() * 180 + 10;
        double centerX2 = Math.random() * 180 + 10;
        double centerY2 = Math.random() * 180 + 10;
        double radius = 10;
        double distance = Math.sqrt(Math.pow(centerX1 - centerX2, 2) + Math.pow(centerY1 - centerY2, 2));
        
        Circle c1 = new Circle(centerX1, centerY1, radius);
        c1.setFill(Color.BLACK);
        Circle c2 = new Circle(centerX2, centerY2, radius);
        c2.setFill(Color.BLACK);
        Line line = new Line(centerX1, centerY1, centerX2, centerY2);
        Text t = new Text((centerX1 + centerX2) / 2, (centerY1 + centerY2) / 2, Double.toString(distance));
        
        pane.getChildren().addAll(c1, c2, line, t);
        Scene scene = new Scene(pane, 250, 250);
        
        primaryStage.setTitle("Distance of Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
