package exercise_16_01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_16_01 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(50, 50, "Programming is fun");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Pane pane = new Pane(text);
        pane.setStyle("-fx-border-color: black");
        
        String[] colors = {"Red", "Yellow", "Black", "Orange", "Green"};
        RadioButton[] radioButtons = new RadioButton[colors.length];
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i < colors.length; i++) {
            radioButtons[i] = new RadioButton(colors[i]);
            radioButtons[i].setToggleGroup(group);
            if(colors[i].equals("Black")) {
                radioButtons[i].setSelected(true);
            }
            final int index = i;
            radioButtons[i].setOnAction(e -> {
                switch(index) {
                    case 0 : 
                        text.setFill(Color.RED);
                        break;
                    case 1 : 
                        text.setFill(Color.YELLOW);
                        break;
                    case 2 : 
                        text.setFill(Color.BLACK);
                        break;
                    case 3 :
                        text.setFill(Color.ORANGE);
                        break;
                    case 4 :
                        text.setFill(Color.GREEN);
                }
            });
        }
        
        HBox hBoxForRadioButtons = new HBox(10);
        hBoxForRadioButtons.setAlignment(Pos.CENTER);
        hBoxForRadioButtons.getChildren().addAll(radioButtons);
        
        Button btLeft = new Button("<=");
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        Button btRight = new Button("=>");
        btRight.setOnAction(e -> text.setX(text.getX() + 10));
        
        HBox hBoxForButtons = new HBox(10);
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.getChildren().addAll(btLeft, btRight);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBoxForRadioButtons);
        borderPane.setBottom(hBoxForButtons);
        borderPane.setCenter(pane);
        
        Scene scene = new Scene(borderPane, 400, 150);
        primaryStage.setTitle("Radio buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
