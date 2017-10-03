package exercise_30_21;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_30_21 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");
        
        Button btSuspend = new Button("Suspend");
        Button btResume = new Button("Resume");
        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btSuspend, btResume, btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);
        
        btSuspend.setOnAction(e -> ballPane.suspend());
        btResume.setOnAction(e -> ballPane.resume());
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());
                
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(hBox);
        
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Exercise_30_21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
