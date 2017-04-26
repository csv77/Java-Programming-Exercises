package exercise_16_20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teststopwatch.StopWatch;

public class Exercise_16_20 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StopWatch stopWatch = new StopWatch();
        
        
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
