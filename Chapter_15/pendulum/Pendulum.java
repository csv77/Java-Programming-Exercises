package pendulum;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Pendulum extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        PendulumPane pendulumPane = new PendulumPane(400, 200);
        pendulumPane.setPadding(new Insets(10, 10, 10, 10));
        
        Scene scene = new Scene(pendulumPane);
        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pendulumPane.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case UP :
                    pendulumPane.increaseSpeed();
                    break;
                case DOWN :
                    pendulumPane.decreaseSpeed();
                    break;
                case R :
                    pendulumPane.play();
                    break;
                case S :
                    pendulumPane.pause();
                    
            }
        });
        pendulumPane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
