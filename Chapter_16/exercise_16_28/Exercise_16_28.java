package exercise_16_28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class Exercise_16_28 extends Application {
    private static final double WIDTH = 300;
    private static final double HEIGHT = 250;
    
    @Override
    public void start(Stage primaryStage) {
        TextPane textPane = new TextPane(WIDTH, HEIGHT);
        
        Scene scene = new Scene(textPane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_16_28");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        textPane.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                textPane.pause();
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                textPane.play();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
