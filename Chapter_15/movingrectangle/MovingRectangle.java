package movingrectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MovingRectangle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rec = new Rectangle(100, 50);
        rec.setStroke(Color.BLACK);
        rec.setFill(Color.WHITE);
        pane.getChildren().add(rec);
        
        rec.setOnMouseDragged(e ->{
            rec.setX(e.getX() - rec.getWidth() / 2);
            rec.setY(e.getY() - rec.getHeight() / 2);
        });
        
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Moving rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
