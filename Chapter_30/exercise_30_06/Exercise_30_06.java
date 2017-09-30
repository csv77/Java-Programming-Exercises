package exercise_30_06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Exercise_30_06 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();

        ballPane.setOnMousePressed(e -> ballPane.suspend());
        ballPane.setOnMouseReleased(e -> ballPane.resume());

        ballPane.setOnKeyPressed(e -> {
          if (e.getCode() == KeyCode.UP) {
            ballPane.increaseSpeed();
          } 
          else if (e.getCode() == KeyCode.DOWN) {
            ballPane.decreaseSpeed();
          }
        });

        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setTitle("Exercise_30_06");
        primaryStage.setScene(scene);
        primaryStage.show();

        ballPane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
