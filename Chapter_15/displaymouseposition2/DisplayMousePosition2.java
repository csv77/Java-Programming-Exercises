/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displaymouseposition2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayMousePosition2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        pane.setOnMousePressed(e -> pane.getChildren().add(new Text(e.getX(), e.getY(),
                "(" + e.getX() + "," + e.getY() + ")")));
        pane.setOnMouseReleased(e -> pane.getChildren().clear());
        
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Display Mouse Position");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
