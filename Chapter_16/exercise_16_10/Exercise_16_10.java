package exercise_16_10;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_16_10 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        TextArea ta = new TextArea();
        ta.setWrapText(true);
        ta.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(ta);
        
        HBox paneForFilename = new HBox();
        TextField tfFilename = new TextField();
        tfFilename.setAlignment(Pos.BOTTOM_LEFT);
        tfFilename.setPrefColumnCount(17);
        Button btView = new Button("View");
        paneForFilename.getChildren().addAll(new Label("Filename"), tfFilename, btView);
        
        pane.getChildren().addAll(scrollPane, paneForFilename);
        
        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Text viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
