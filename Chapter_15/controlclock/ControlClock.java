package controlclock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControlClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ClockPane clockPane = new ClockPane();
        //
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button stop = new Button("Stop");
        Button start = new Button("Start");
        hBox.getChildren().addAll(stop, start);
        
        BorderPane pane = new BorderPane(clockPane);
        pane.setBottom(hBox);
        Scene scene = new Scene(pane, 250, 270);
        primaryStage.setTitle("Control Clock");
        primaryStage.setScene(scene);
        primaryStage.setX(1650);
        primaryStage.setY(0);
        primaryStage.show();
        
        stop.setOnAction(e -> clockPane.pause());
        start.setOnAction(e -> clockPane.play());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
