package exercise_16_07;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import detailedclock.ClockPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Exercise_16_07 extends Application {
    private TextField tfHour = new TextField();
    private TextField tfMinute = new TextField();
    private TextField tfSecond = new TextField();
    private ClockPane clockPane = new ClockPane();
            
    @Override
    public void start(Stage primaryStage) {
        HBox hBoxForPanel = new HBox(5);
        hBoxForPanel.setAlignment(Pos.CENTER);
        
        tfHour.setPrefColumnCount(4);
        tfMinute.setPrefColumnCount(4);
        tfSecond.setPrefColumnCount(4);
        tfHour.setAlignment(Pos.BOTTOM_RIGHT);
        tfMinute.setAlignment(Pos.BOTTOM_RIGHT);
        tfSecond.setAlignment(Pos.BOTTOM_CENTER);
        hBoxForPanel.getChildren().addAll(new Label("Hour"), tfHour, new Label("Minute"), tfMinute, new Label("Second"), tfSecond);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBoxForPanel);
        borderPane.setCenter(clockPane);
        borderPane.setPadding(new Insets(5, 5, 5, 5));
        
        tfHour.setOnAction(e -> setClock());
        
        tfMinute.setOnAction(e -> setClock());
        
        tfSecond.setOnAction(e -> setClock());
        
        borderPane.widthProperty().addListener(ov -> clockPane.setW(borderPane.getWidth() - 20));
        borderPane.heightProperty().addListener(ov -> clockPane.setH(borderPane.getHeight() - 20));
        
        Scene scene = new Scene(borderPane, 350, 300);
        primaryStage.setTitle("Set Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setClock() {
        clockPane.setHour(Integer.parseInt(tfHour.getText()));
        clockPane.setMinute(Integer.parseInt(tfMinute.getText()));
        clockPane.setSecond(Integer.parseInt(tfSecond.getText()));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
