package exercise_23_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Exercise_23_15 extends Application {
    private BorderPane borderPane = new BorderPane();
    private ArrayList<Integer> list;
    private Label[] lbChart = new Label[20];
    private Rectangle[] rectangles = new Rectangle[20];
    private HBox hBoxForChart = new HBox();
    private int stepNumber = 0;
    
    @Override
    public void start(Stage primaryStage) {
        borderPane.setPadding(new Insets(5));
        
        HBox hBoxForButtons = new HBox();
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.setSpacing(5);

        hBoxForChart.setAlignment(Pos.BOTTOM_CENTER);
        hBoxForChart.setStyle("-fx-border-color : black");
        
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        
        hBoxForButtons.getChildren().addAll(btStep, btReset);
        list = createArrayList();
        Collections.shuffle(list);
        repaintHistogram();
        
        
        btStep.setOnAction(e -> {
            if(stepNumber < list.size()) {
                oneStep();
                repaintHistogram();
                rectangles[stepNumber].setFill(Color.BLUE);
                stepNumber++;
            }
        });
        
        btReset.setOnAction(e -> {
            Collections.shuffle(list);
            repaintHistogram();
            stepNumber = 0;
        });
        
        borderPane.setBottom(hBoxForButtons);
        borderPane.setCenter(hBoxForChart);
                
        Scene scene = new Scene(borderPane, 500, 300);
        primaryStage.setTitle("Exercise_23_15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void oneStep() {
        if(stepNumber >= list.size() - 1) {
            return;
        }
        int min = list.get(stepNumber);
        int minIndex = stepNumber;
        for(int j = stepNumber + 1; j < list.size(); j++) {
            if(min > list.get(j)) {
                min = list.get(j);
                minIndex = j;
            }
        }
        if(minIndex != stepNumber) {
            list.set(minIndex, list.get(stepNumber));
            list.set(stepNumber, min); 
        }
    }
    
    public void repaintHistogram() {
        hBoxForChart.getChildren().clear();
        int j = 0;
        for(Integer i : list) {
            rectangles[j] = new Rectangle(23, i * 10);
            rectangles[j].setStroke(Color.BLACK);
            rectangles[j].setFill(Color.TRANSPARENT);
            lbChart[j] = new Label(i + "", rectangles[j]);
            lbChart[j].setContentDisplay(ContentDisplay.BOTTOM);
            hBoxForChart.getChildren().add(lbChart[j]);
            j++;
        }
    }
    
    public ArrayList<Integer> createArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
