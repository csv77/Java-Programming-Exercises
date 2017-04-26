package exercise_16_18;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import runningfan.FanPane;

public class Exercise_16_18 extends Application {
    private final static double WIDTH = 300;
    private final static double HEIGHT = 300;
    private final static double RADIUS = 100;
    
    @Override
    public void start(Stage primaryStage) {
        FanPane fanPane = new FanPane(WIDTH, HEIGHT, RADIUS);
        fanPane.play();
        
        Slider slider = new Slider();
        slider.setMax(10);
        slider.setValue(5);
        
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        hBox.getChildren().addAll(pause, resume, reverse);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(fanPane);
        pane.setTop(hBox);
        pane.setBottom(slider);
        
        pause.setOnAction(e -> fanPane.pause());
        resume.setOnAction(e -> fanPane.play());
        reverse.setOnAction(e -> fanPane.reverse());
        fanPane.getRateProperty().bind(slider.valueProperty());
        
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_16_18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
