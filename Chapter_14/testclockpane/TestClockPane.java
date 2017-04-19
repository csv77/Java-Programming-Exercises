package testclockpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestClockPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        ClockPane clock1 = new ClockPane(4, 20, 45);
        ClockPane clock2 = new ClockPane(22, 46, 15);
        
        hBox.getChildren().addAll(clock1, clock2);
        
        Scene scene = new Scene(hBox);
        primaryStage.setTitle("Two clocks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
