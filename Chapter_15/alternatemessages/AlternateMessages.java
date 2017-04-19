package alternatemessages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlternateMessages extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Text text1 = new Text("Java is fun");
        Text text2 = new Text("Java is powerful");
        pane.getChildren().add(text1);
        
        pane.setOnMouseClicked(e -> {
            if(pane.getChildren().contains(text1)) {
                pane.getChildren().remove(text1);
                pane.getChildren().add(text2);
            }
            else if(pane.getChildren().contains(text2)) {
                pane.getChildren().remove(text2);
                pane.getChildren().add(text1);
            }
        });

        Scene scene = new Scene(pane, 150, 100);
        primaryStage.setTitle("Alternate messages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
