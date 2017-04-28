package exercise_16_25;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_16_25 extends Application {
    private static final int NUMBER_OF_CARS = 4;
    private CarPane[] carPane = new CarPane[NUMBER_OF_CARS];
    private TextField[] tfCar = new TextField[NUMBER_OF_CARS];
    private Label[] lbCar = new Label[NUMBER_OF_CARS];
    private Pane[] paneForCar = new Pane[NUMBER_OF_CARS];
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5);
        VBox pane = new VBox(5);
        pane.getChildren().add(hBox);
        
        for(int i = 0; i < NUMBER_OF_CARS; i++) {
            carPane[i] = new CarPane(0, 50);
            carPane[i].setStyle("-fx-border-color: black");
            
            tfCar[i] = new TextField();
            tfCar[i].setPrefColumnCount(3);
            
            lbCar[i] = new Label("Car " + (i + 1) + ":", tfCar[i]);
            lbCar[i].setContentDisplay(ContentDisplay.RIGHT);
            hBox.getChildren().add(lbCar[i]);
            
            pane.getChildren().add(carPane[i]);
            
            final int index = i;
            tfCar[i].setOnAction(e -> {
                carPane[index].setSpeed(Double.parseDouble(tfCar[index].getText()));
                carPane[index].play();
            });
        }
        
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise_16_25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
