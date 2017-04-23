package exercise_16_02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_16_02 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        Rectangle rectangle = new Rectangle(150, 100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        
        Ellipse ellipse = new Ellipse(100, 50);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-border-color: black");
        
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        RadioButton rbCircle = new RadioButton("Circle");
        RadioButton rbRectangle = new RadioButton("Rectangle");
        RadioButton rbEllipse = new RadioButton("Ellipse");
        CheckBox cbFill = new CheckBox("Fill");
        hBox.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, cbFill);
        
        ToggleGroup group = new ToggleGroup();
        rbCircle.setToggleGroup(group);
        rbRectangle.setToggleGroup(group);
        rbEllipse.setToggleGroup(group);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(stackPane);
        pane.setBottom(hBox);
        
        rbCircle.setOnAction(e -> {
            if(rbCircle.isSelected()) {
                stackPane.getChildren().clear();
                stackPane.getChildren().add(circle);
            }
        });
        
        rbRectangle.setOnAction(e -> {
            if(rbRectangle.isSelected()) {
                stackPane.getChildren().clear();
                stackPane.getChildren().add(rectangle);
            }
        });
        
        rbEllipse.setOnAction(e -> {
            if(rbEllipse.isSelected()) {
                stackPane.getChildren().clear();
                stackPane.getChildren().add(ellipse);
            }
        });
        
        cbFill.setOnAction(e -> {
            if(cbFill.isSelected()) {
                circle.setFill(Color.BLACK);
                rectangle.setFill(Color.BLACK);
                ellipse.setFill(Color.BLACK);
            }
            else {
                circle.setFill(Color.WHITE);
                rectangle.setFill(Color.WHITE);
                ellipse.setFill(Color.WHITE);
            }
        });
        
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Select Geometric Figures");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
