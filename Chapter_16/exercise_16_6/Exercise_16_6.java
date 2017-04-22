package exercise_16_6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_16_6 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox paneForTextField = new HBox(5);
        paneForTextField.setAlignment(Pos.CENTER);
        TextField tfTextField = new TextField("JavaFX");
        tfTextField.setPrefColumnCount(12);
        tfTextField.setAlignment(Pos.CENTER);
        paneForTextField.getChildren().addAll(new Label("Text Field"), tfTextField);
        
        HBox paneForRadioButtonsAndColumnSize = new HBox(5);
        paneForRadioButtonsAndColumnSize.setAlignment(Pos.CENTER);
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        rbCenter.setSelected(true);
        RadioButton rbRight = new RadioButton("Right");
        
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        
        TextField tfColumnSize = new TextField(String.valueOf(tfTextField.getPrefColumnCount()));
        tfColumnSize.setPrefColumnCount(4);
        tfColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        paneForRadioButtonsAndColumnSize.getChildren().addAll(rbLeft, rbCenter, rbRight, new Label("Column Size"), tfColumnSize);
        
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(paneForTextField, paneForRadioButtonsAndColumnSize);
        
        rbLeft.setOnAction(e -> {
            if(rbLeft.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_LEFT);
            }
        });
        
        rbCenter.setOnAction(e -> {
            if(rbCenter.isSelected()) {
                tfTextField.setAlignment(Pos.CENTER);
            }
        });
        
        rbRight.setOnAction(e -> {
            if(rbRight.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
            }
        });
        
        tfColumnSize.setOnAction(e -> {
            tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText()));
        });
        
        Scene scene = new Scene(vBox, 320, 70);
        primaryStage.setTitle("TextField");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
