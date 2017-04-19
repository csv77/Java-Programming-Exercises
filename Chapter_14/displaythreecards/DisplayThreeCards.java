package displaythreecards;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DisplayThreeCards extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(5);
        pane.setPadding(new Insets(5, 15, 5, 15));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 52; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for(int i = 0; i < 3; i++) {
            pane.getChildren().add(new ImageView(new Image("image/card/" + (list.get(i)) + ".png")));
        }
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Display Three Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
