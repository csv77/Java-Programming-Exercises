package exercise_16_10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise_16_10 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Text viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
