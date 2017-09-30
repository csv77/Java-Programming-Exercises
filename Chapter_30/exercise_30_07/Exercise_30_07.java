package exercise_30_07;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_30_07 extends Application {

    @Override
    public void start(Stage primaryStage) {
        ClockPane clockPane = new ClockPane();
        
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button stop = new Button("Stop");
        Button start = new Button("Start");
        hBox.getChildren().addAll(stop, start);
        
        BorderPane pane = new BorderPane(clockPane);
        pane.setBottom(hBox);
        
        Scene scene = new Scene(pane, 250, 270);
        primaryStage.setTitle("Exercise_30_07");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        stop.setOnAction(e -> clockPane.suspend());
        start.setOnAction(e -> clockPane.resume());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
