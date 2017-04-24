package exercise_16_12;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_16_12 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(false);
        ScrollPane scrollPane = new ScrollPane(textArea);
        
        HBox hBoxForCheckBoxes = new HBox(10);
        hBoxForCheckBoxes.setAlignment(Pos.CENTER);
        
        CheckBox chbEditable = new CheckBox("Editable");
        CheckBox chbWrap = new CheckBox("Wrap");
        hBoxForCheckBoxes.getChildren().addAll(chbEditable, chbWrap);
        pane.getChildren().addAll(scrollPane, hBoxForCheckBoxes);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TextArea");
        primaryStage.setScene(scene);
        
        chbEditable.setOnAction(e -> textArea.setEditable(chbEditable.isSelected()));
        chbWrap.setOnAction(e -> textArea.setWrapText(chbWrap.isSelected()));
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
