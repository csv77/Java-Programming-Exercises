package insidepolygon2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsidePolygon2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        list.addAll(40.0, 20.0, 70.0, 40.0, 60.0, 80.0, 45.0, 45.0, 20.0, 60.0);
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.WHITE);
        pane.getChildren().add(polygon);
        
        pane.setOnMouseMoved(e -> {
            pane.getChildren().clear();
            Text text = new Text(e.getX(), e.getY(), "Mouse point is " + (polygon.contains(e.getX(), e.getY()) ?
                    "inside" : "outside") + " the polygon");
            pane.getChildren().addAll(polygon, text);
        });
        
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Inside a polygon?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
