package displaycheckerboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DisplayCheckerboard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                Rectangle r1 = new Rectangle(25, 25);
                if(count % 2 == 0) {
                    r1.setFill(Color.WHITE);
                }
                pane.add(r1, i, j);
                count++;
            }
            count++;
        }
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Checkerboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
