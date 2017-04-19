package racingcar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class RacingCar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CarPane carPane = new CarPane(-50, 250);
        
        Scene scene = new Scene(carPane, 300, 250);
        primaryStage.setTitle("Racing car");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        carPane.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.UP)) {
                carPane.increaseSpeed();
            }
            else if(e.getCode().equals(KeyCode.DOWN)) {
                carPane.decreaseSpeed();
            }
        });
        
        carPane.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                carPane.pause();
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                carPane.play();
            }
        });
        carPane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
