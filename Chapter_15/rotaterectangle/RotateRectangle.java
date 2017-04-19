package rotaterectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RotateRectangle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
                
        Button btRotate = new Button("Rotate");
        Rectangle rectangle = new Rectangle(80, 40);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        
        pane.setBottom(btRotate);
        pane.setCenter(rectangle);
        BorderPane.setAlignment(rectangle, Pos.CENTER);
        BorderPane.setAlignment(btRotate, Pos.CENTER);
        
        btRotate.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY) {
                rectangle.setRotate(rectangle.getRotate() + 15);
            }
            else if(e.getButton() == MouseButton.SECONDARY){
                rectangle.setRotate(rectangle.getRotate() - 15);
            }
        });
        
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Rotate Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
