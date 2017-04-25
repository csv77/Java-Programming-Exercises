package exercise_16_16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_16_16 extends Application {
    private ComboBox cbSelectionMode = new ComboBox(FXCollections.observableArrayList("SINGLE", "MULTIPLE"));
    private ListView<String> lvCountries = new ListView(FXCollections.observableArrayList("China", "Japan", "Korea",
            "India", "Malaysia", "Vietnam", "Nepal", "Indonesia", "Burma", "Bangladesh"));
    private Label text = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        HBox paneForComboBox = new HBox();
        paneForComboBox.setAlignment(Pos.CENTER);
        cbSelectionMode.setValue("SINGLE");
        paneForComboBox.getChildren().addAll(new Label("Choose selection mode: "), cbSelectionMode);
        lvCountries.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        cbSelectionMode.setOnAction(e -> setText());
        lvCountries.getSelectionModel().selectedItemProperty().addListener(ov -> {
            setText();
        });
        
        BorderPane pane = new BorderPane();
        pane.setTop(paneForComboBox);
        pane.setCenter(lvCountries);
        pane.setBottom(text);
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("ListView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setText() {
        if(cbSelectionMode.getValue().equals("SINGLE")) {
            lvCountries.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            text.setText("Selected item is " + printList());
        }
        else {
            lvCountries.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            text.setText("Selected items are " + printList());
        }
        
    }
    
    public String printList() {
        String countries = "";
        for(String i : lvCountries.getSelectionModel().getSelectedItems()) {
            countries += i + " ";
        }
        return countries;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
