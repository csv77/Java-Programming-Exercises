package displaymouseposition;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayMousePosition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        pane.setOnMouseClicked(e -> {
            pane.getChildren().clear();
            pane.getChildren().add(new Text(e.getX(), e.getY(), "(" + e.getX() + "," + e.getY() + ")"));
        });
        
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Display Mouse Position");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
