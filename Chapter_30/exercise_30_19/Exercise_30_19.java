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
        ArrayList<Integer> listOfElements = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            listOfElements.add(i + 1);
        }
        Collections.shuffle(listOfElements);
        
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        
        HistogramPane paneForSelectionSort = new SelectionSortPane(listOfElements, new Label("Selection Sort"));
        HistogramPane paneForInsertionSort = new InsertionSortPane(listOfElements, new Label("Insertion Sort"));
        HistogramPane paneForBubbleSort = new BubbleSortPane(listOfElements, new Label("Bubble Sort"));
        hBox.getChildren().addAll(paneForSelectionSort, paneForInsertionSort, paneForBubbleSort);
        
        Scene scene = new Scene(hBox);
        scene.getStylesheets().add("file:///c:/programming/java/Intro_to_Java_Programming_10th_exercises/JavaProgrammingExercises/Chapter_30/exercise_30_19/style2.css");
        primaryStage.setTitle("Exercise_30_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private abstract class HistogramPane extends BorderPane {
        protected Integer[] list;
        protected HBox hBoxForChart = new HBox();
        protected Label lblSortType;
        protected Rectangle[] rectangles;
        protected final int WIDTH = 5;
        protected final int HEIGHT = 5;

        public HistogramPane(ArrayList<Integer> list, Label lblSortType) {
            this.list = new Integer[list.size()];
            this.list = list.toArray(this.list);
            this.lblSortType = lblSortType;
            rectangles = new Rectangle[list.size()];
            setCenter(hBoxForChart);
            setTop(lblSortType);
            BorderPane.setAlignment(lblSortType, Pos.CENTER);
            repaintHistogram(-1);
        }

        public void repaintHistogram(int index) {
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
            if(index != -1) {
                rectangles[index].setFill(Color.BLUE);
            }
        }
    }
    
    private class SelectionSortPane extends HistogramPane implements Runnable {
        
        public SelectionSortPane(ArrayList<Integer> list, Label lblSortType) {
            super(list, lblSortType);
            Thread thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            try {
                for(int i = 0; i < list.length - 1; i++) {
                    int currentMin = list[i];
                    int currentMinIndex = i;
                    for(int j = i + 1; j < list.length; j++) {
                        if(currentMin > list[j]) {
                            currentMin = list[j];
                            currentMinIndex = j;
                        }
                    }
                    if(currentMinIndex != i) {
                        list[currentMinIndex] = list[i];
                        list[i] = currentMin;
                    }
                    int index = i;
                    Platform.runLater(() -> repaintHistogram(index));
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Platform.runLater(() -> repaintHistogram(list.length - 1));
        }
    }
    
    private class InsertionSortPane extends HistogramPane implements Runnable {
        
        public InsertionSortPane(ArrayList<Integer> list, Label lblSortType) {
            super(list, lblSortType);
            Thread thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            try {
                for(int i = 1; i < list.length; i++) {
                    int currentElement = list[i];
                    int k;
                    for(k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                        list[k + 1] = list[k];
                    }
                    list[k + 1] = currentElement;
                    int index = i;
                    Platform.runLater(() -> repaintHistogram(index));
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private class BubbleSortPane extends HistogramPane implements Runnable {
        
        public BubbleSortPane(ArrayList<Integer> list, Label lblSortType) {
            super(list, lblSortType);
            Thread thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            boolean needNextPass = true;
            int l = 0;
            try {
                for(int k = 1; k < list.length && needNextPass; k++) {
                    needNextPass = false;
                    for(int i = 0; i < list.length - k; i++) {
                        if(list[i] > list[i + 1]) {
                            Integer temp = list[i];
                            list[i] = list[i + 1];
                            list[i + 1] = temp;
                            needNextPass = true;
                        }
                    }
                    int index = list.length - k;
                    l = index;
                    Platform.runLater(() -> repaintHistogram(index));
                    Thread.sleep(500);
                }
                while(l >= 0) {
                    int index = l;
                    Platform.runLater(() -> repaintHistogram(index));
                    l--;
                    Thread.sleep(500);
                }
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
