package exercise_20_02;

import java.util.Collections;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_20_02 extends Application {
    private TextArea tArea = new TextArea();
    private TextField tfInput = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        LinkedList<Integer> list = new LinkedList<>();
        
        BorderPane pane = new BorderPane();
        tfInput.setPrefColumnCount(10);
        Label label = new Label("Enter a number: ", tfInput);
        label.setContentDisplay(ContentDisplay.RIGHT);
        
        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btSort, btShuffle, btReverse);
        
        tArea.setWrapText(true);
        tArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(tArea);
        
        tfInput.setOnAction(e -> {
            if(Character.isDigit(tfInput.getText().charAt(0))) {
                if(!list.contains(Integer.parseInt(tfInput.getText()))) {
                    list.add(Integer.parseInt(tfInput.getText()));
                }
            }
            else {
                System.out.println("It is not a number!");
            }
            displayList(list);
        });
        
        btSort.setOnAction(e -> {
            Collections.sort(list);
            displayList(list);
        });
        
        btShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            displayList(list);
        });
        
        btReverse.setOnAction(e -> {
            Collections.reverse(list);
            displayList(list);
        });
        
        pane.setCenter(scrollPane);
        pane.setBottom(hBox);
        pane.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Exercise_20_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void displayList(LinkedList<Integer> list) {
        String text = "";
        for(Integer nr : list) {
            text += nr + " ";
        }
        tArea.setText(text);
        tfInput.clear();
    }
    
}
