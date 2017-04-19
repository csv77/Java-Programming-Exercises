package colorandfont;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorAndFont extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(5, 15, 5, 15));
        pane.setAlignment(Pos.CENTER);
        for(int i = 0; i < 5; i++) {
            Text text = new Text("Java");
            text.setFill(new Color((Math.random()), (Math.random()), (Math.random()), (Math.random())));
            text.setRotate(90);
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
            pane.getChildren().add(text);
        }
        
        Scene scene = new Scene(pane, 300, 100);
        
        primaryStage.setTitle("Color and Font");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
