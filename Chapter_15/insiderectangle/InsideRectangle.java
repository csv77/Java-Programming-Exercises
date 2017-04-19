package insiderectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsideRectangle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(100, 60, 100, 40);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        pane.getChildren().add(rectangle);
        
        pane.setOnMouseMoved(e -> {
            pane.getChildren().clear();
            pane.getChildren().addAll(rectangle, new Text(e.getX(), e.getY(), "Mouse point is " + (rectangle.contains(e.getX(), e.getY()) ? 
                    "inside" : "outside") + " the rectangle"));
        });
        
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Inside a rectangle?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
