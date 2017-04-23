package exercise_16_04;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise_16_04 extends Application {
    final static double KM_PER_MILE = 1.602307322544464;
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        Label mile = new Label("Mile");
        Label kilometer = new Label("Kilometer");
        TextField mileField = new TextField();
        TextField kilometerField = new TextField();
        mileField.setAlignment(Pos.BOTTOM_RIGHT);
        kilometerField.setAlignment(Pos.BOTTOM_RIGHT);
        
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.add(mile, 0, 0);
        pane.add(kilometer, 0, 1);
        pane.add(mileField, 1, 0);
        pane.add(kilometerField, 1, 1);
        GridPane.setHalignment(mile, HPos.LEFT);
        GridPane.setHalignment(kilometer, HPos.LEFT);
        
        mileField.setOnAction(e -> {
            kilometerField.clear();
            kilometerField.setText(String.valueOf(Double.parseDouble(mileField.getText()) * KM_PER_MILE));
        });
        
        kilometerField.setOnAction(e -> {
            mileField.clear();
            mileField.setText(String.valueOf(Double.parseDouble(kilometerField.getText()) / KM_PER_MILE));
        });
        
        Scene scene = new Scene(pane, 250, 70);
        primaryStage.setTitle("Miles/Kilometer converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
