package randomtime;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RandomTime extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        clock.setHour((int)(Math.random() * 11));
        clock.setMinute((int)(Math.random() * 2) == 1 ? 30 : 0);
        clock.setSecondHandVisible(false);
        
        String timeString = clock.getHour() + ":" + clock.getMinute() 
          + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
