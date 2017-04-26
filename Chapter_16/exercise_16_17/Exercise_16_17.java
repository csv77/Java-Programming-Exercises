package exercise_16_17;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_16_17 extends Application {
    private Text text = new Text("Show Colors");
    private ScrollBar sbRed = new ScrollBar();
    private ScrollBar sbGreen = new ScrollBar();
    private ScrollBar sbBlue = new ScrollBar();
    private ScrollBar sbOpacity = new ScrollBar();
    
    @Override
    public void start(Stage primaryStage) {
        Label red = new Label("Red");
        Label green = new Label("Green");
        Label blue = new Label("Blue");
        Label opacity = new Label("Opacity");
        text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        sbOpacity.setValue(100);
        
        GridPane paneForScrollBars = new GridPane();
        paneForScrollBars.setVgap(5);
        paneForScrollBars.setHgap(5);
        paneForScrollBars.setAlignment(Pos.CENTER);
        paneForScrollBars.add(red, 0, 0);
        paneForScrollBars.add(sbRed, 1, 0);
        paneForScrollBars.add(green, 0, 1);
        paneForScrollBars.add(sbGreen, 1, 1);
        paneForScrollBars.add(blue, 0, 2);
        paneForScrollBars.add(sbBlue, 1, 2);
        paneForScrollBars.add(opacity, 0, 3);
        paneForScrollBars.add(sbOpacity, 1, 3);
        
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20, 10, 15, 10));
        vBox.getChildren().addAll(text, paneForScrollBars);
        vBox.setAlignment(Pos.CENTER);
        
        sbRed.valueProperty().addListener(ov -> setColor());
        sbGreen.valueProperty().addListener(ov -> setColor());
        sbBlue.valueProperty().addListener(ov -> setColor());
        sbOpacity.valueProperty().addListener(ov -> setColor());
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("ScrollBar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setColor() {
        text.setFill(new Color(sbRed.getValue() / 100, sbGreen.getValue() / 100, sbBlue.getValue() / 100, sbOpacity.getValue() / 100));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
