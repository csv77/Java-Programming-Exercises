package exercise_16_5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise_16_5 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        TextField decimal = new TextField();
        TextField hex = new TextField();
        TextField binary = new TextField();
        decimal.setAlignment(Pos.BOTTOM_RIGHT);
        hex.setAlignment(Pos.BOTTOM_RIGHT);
        binary.setAlignment(Pos.BOTTOM_RIGHT);
        
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.add(new Label("Decimal"), 0, 0);
        pane.add(new Label("Hex"), 0, 1);
        pane.add(new Label("Binary"), 0, 2);
        pane.add(decimal, 1, 0);
        pane.add(hex, 1, 1);
        pane.add(binary, 1, 2);
        
        decimal.setOnAction(e -> {
            hex.setText(Integer.toHexString(Integer.parseInt(decimal.getText())).toUpperCase());
            binary.setText(Integer.toBinaryString(Integer.parseInt(decimal.getText())));
            pane.requestFocus();
        });
        
        hex.setOnAction(e -> {
            hex.setText(hex.getText().toUpperCase());
            decimal.setText(String.valueOf(Integer.parseInt(hex.getText(), 16)));
            binary.setText(Integer.toBinaryString(Integer.parseInt(decimal.getText())));
            pane.requestFocus();
        });
        
        binary.setOnAction(e -> {
            decimal.setText(String.valueOf(Integer.parseInt(binary.getText(), 2)));
            hex.setText(Integer.toHexString(Integer.parseInt(decimal.getText())).toUpperCase());
            pane.requestFocus();
        });
        
        pane.setOnKeyPressed(e -> {
            if(e.getCode() == (KeyCode.DELETE)) {
                decimal.clear();
                hex.clear();
                binary.clear();
            }
        });
        
        Scene scene = new Scene(pane, 250, 100);
        primaryStage.setTitle("Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
