package exercise_30_19;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_30_19 extends Application {

    @Override
    public void start(Stage primaryStage) {
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            list1.add(i + 1);
        }
        Collections.shuffle(list1);
        
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        
        HistogramPane pane1 = new SelectionSortPane(list1, new Label("Selection Sort"));
//        HistogramPane pane2 = new HistogramPane(list1, new Label("Insertion Sort"));
//        HistogramPane pane3 = new HistogramPane(list1, new Label("Bubble Sort"));
        hBox.getChildren().addAll(pane1);
        
        Scene scene = new Scene(hBox);
        scene.getStylesheets().add("file:///c:/programming/java/Intro_to_Java_Programming_10th_exercises/JavaProgrammingExercises/Chapter_30/exercise_30_19/style2.css");
        primaryStage.setTitle("Exercise_30_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private abstract class HistogramPane extends BorderPane {
        protected ArrayList<Integer> list;
        protected HBox hBoxForChart = new HBox();
        protected Label lblSortType;
        protected Rectangle[] rectangles;
        protected final int WIDTH = 5;
        protected final int HEIGHT = 5;

        public HistogramPane(ArrayList<Integer> list, Label lblSortType) {
            this.list = list;
            this.lblSortType = lblSortType;
            rectangles = new Rectangle[list.size()];
            setCenter(hBoxForChart);
            setTop(lblSortType);
            BorderPane.setAlignment(lblSortType, Pos.CENTER);
            repaintHistogram();
        }

        public void repaintHistogram() {
            hBoxForChart.getChildren().clear();
            hBoxForChart.setAlignment(Pos.BASELINE_CENTER);
            int j = 0;
            for(Integer i : list) {
                rectangles[j] = new Rectangle(WIDTH, i * HEIGHT);
                rectangles[j].setStroke(Color.BLACK);
                rectangles[j].setFill(Color.TRANSPARENT);
                hBoxForChart.getChildren().add(rectangles[j]);
                j++;
            }
        }
    }
    
    private class SelectionSortPane extends HistogramPane {
        
        public SelectionSortPane(ArrayList<Integer> list, Label lblSortType) {
            super(list, lblSortType);
        }

        public void selectionSort() {
            for(int i = 0; i < list.size() - 1; i++) {
                int currentMin = list.get(i);
                int currentMinIndex = i;
                for(int j = i + 1; j < list.size(); j++) {
                    if(currentMin > list.get(j)) {
                        currentMin = list.get(j);
                        currentMinIndex = j;
                    }
                }
                if(currentMinIndex != i) {
                    list.set(currentMinIndex, list.get(i));
                    list.set(i, currentMin);
                }
                repaintHistogram();
            }
        }
    }
        
    public static void main(String[] args) {
        launch(args);
    }
}
