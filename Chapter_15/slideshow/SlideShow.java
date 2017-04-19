package slideshow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SlideShow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ImagePane imagePane = new ImagePane();
        
        Scene scene = new Scene(imagePane);
        primaryStage.setTitle("Slide show");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        imagePane.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                imagePane.pause();
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                imagePane.play();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
