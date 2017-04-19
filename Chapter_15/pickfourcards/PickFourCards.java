package pickfourcards;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PickFourCards extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setAlignment(Pos.CENTER);
        
        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setAlignment(Pos.CENTER);
        
        Button button = new Button("Refresh");
        vBox.getChildren().addAll(hBox, button);
                
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 52; i++) {
            list.add(i);
        }
        
        getCards(hBox, list);
        
        button.setOnAction(e -> getCards(hBox, list));
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Pick Four Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void getCards(HBox hBox, ArrayList<Integer> list) {
        hBox.getChildren().clear();
        Collections.shuffle(list);
        for(int i = 0; i < 4; i++) {
            hBox.getChildren().add(new ImageView(new Image("image/card/" + (list.get(i)) + ".png")));
        }
    }
}
