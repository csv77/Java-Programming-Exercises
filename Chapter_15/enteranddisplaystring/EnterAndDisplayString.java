package enteranddisplaystring;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EnterAndDisplayString extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        StackPane pane = new StackPane(label);

        StringBuilder s = new StringBuilder();
        pane.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                label.setText(s.toString());
                s.delete(0, s.length());
            } else {
                s.append(e.getText());
            }
        });
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Enter and Display String");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
