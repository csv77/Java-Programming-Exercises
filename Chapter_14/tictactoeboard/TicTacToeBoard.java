package tictactoeboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TicTacToeBoard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        Image x = new Image("image/x.gif");
        Image o = new Image("image/o.gif");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int random = (int)(Math.random() * 3);
                if(random == 0) {
                    pane.add((new ImageView(new Image("image/x.gif"))), j, i);
                }
                else if(random == 1) {
                    pane.add((new ImageView(new Image("image/o.gif"))), j, i);
                }
                else{
                }
            }
        }
        
        Scene scene = new Scene(pane, 120, 130);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
