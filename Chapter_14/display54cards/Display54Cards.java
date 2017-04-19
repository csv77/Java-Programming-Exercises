package display54cards;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Display54Cards extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 54; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int count = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 9; j++) {
                pane.add(new ImageView(new Image("image/card/" + list.get(count) + ".png")), j, i);
                count++;
            }
        }
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("54 Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
