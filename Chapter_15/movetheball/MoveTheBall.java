package movetheball;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveTheBall extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();
        
        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setAlignment(Pos.CENTER);
        
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Dowmn");
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
        
        btLeft.setOnAction(e -> ballPane.left());
        btRight.setOnAction(e -> ballPane.right());
        btUp.setOnAction(e -> ballPane.up());
        btDown.setOnAction(e -> ballPane.down());
        
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(hBox);
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Move the Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
