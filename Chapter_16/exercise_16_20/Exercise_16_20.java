package exercise_16_20;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_16_20 extends Application {
    private Button btControl = new Button("Start");
    private Button btClear = new Button("Clear");
    
    @Override
    public void start(Stage primaryStage) {
        StopWatch stopWatch = new StopWatch();
        HBox paneForButtons = new HBox(5);
        paneForButtons.getChildren().addAll(btControl, btClear);
        paneForButtons.setAlignment(Pos.CENTER);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(stopWatch);
        pane.setBottom(paneForButtons);
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        btControl.setOnAction(e -> {
            if(btControl.getText() == "Start" || btControl.getText() == "Resume") {
                btControl.setText("Pause");
                stopWatch.play();
            }
            else if(btControl.getText() == "Pause") {
                btControl.setText("Resume");
                stopWatch.pause();
            }
        });
        
        btClear.setOnAction(e -> {
            btControl.setText("Start");
            stopWatch.clear();
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
