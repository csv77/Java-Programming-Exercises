package changecolor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ChangeColor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);
        
        pane.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        pane.setOnMouseReleased(e -> circle.setFill(Color.WHITE));
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Change color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
