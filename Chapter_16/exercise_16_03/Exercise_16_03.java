package exercise_16_03;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_16_03 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane paneForLight = new StackPane();
        Rectangle r = new Rectangle(30, 90);
        r.setStroke(Color.BLACK);
        r.setFill(Color.WHITE);
        
        VBox paneForCircles = new VBox(10);
        Circle c1 = getCircle();
        Circle c2 = getCircle();
        Circle c3 = getCircle();
        paneForCircles.setAlignment(Pos.CENTER);
        paneForCircles.getChildren().addAll(c1, c2, c3);
        paneForLight.getChildren().add(r);
        paneForLight.getChildren().add(paneForCircles);
        
        HBox paneForRadioButtons = new HBox(10);
        paneForRadioButtons.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(paneForLight);
        borderPane.setBottom(paneForRadioButtons);
        
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbGreen);
        
        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()) {
                c2.setFill(Color.WHITE);
                c3.setFill(Color.WHITE);
                c1.setFill(Color.RED);
            }
        });
        
        rbYellow.setOnAction(e -> {
            if(rbYellow.isSelected()) {
                c1.setFill(Color.WHITE);
                c3.setFill(Color.WHITE);
                c2.setFill(Color.YELLOW);
            }
        });
        
        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()) {
                c1.setFill(Color.WHITE);
                c2.setFill(Color.WHITE);
                c3.setFill(Color.GREEN);
            }
        });
        
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Traffic lights");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Circle getCircle() {
        Circle c = new Circle(10);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        return c;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
