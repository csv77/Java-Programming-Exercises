package insidecircle;

import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsideCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle(100, 60, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);
        
        pane.setOnMouseMoved(e -> {
            pane.getChildren().clear();
            Text text = new Text(e.getX(), e.getY(), "Mouse point is " + (circle.contains(e.getX(), e.getY()) ? 
                    "inside" : "outside") + " the circle");
            pane.getChildren().addAll(circle, text);
        });
        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Inside a circle?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
