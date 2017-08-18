package exercise_23_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_23_16 extends Application {
    private static final int SIZE = 20;
    
    @Override
    public void start(Stage primaryStage) {
        HBoxForHistogram hBoxForHistogram = new HBoxForHistogram();
        hBoxForHistogram.setStyle("-fx-border-color : black");
        hBoxForHistogram.setAlignment(Pos.BOTTOM_CENTER);
        
        HBox hBoxForButtons = new HBox();
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.setSpacing(5);
        
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        hBoxForButtons.getChildren().addAll(btStep, btReset);
        
        Label lbStatus = new Label();
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));
        borderPane.setCenter(hBoxForHistogram);
        borderPane.setBottom(hBoxForButtons);
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 500, 300);
        primaryStage.setTitle("Exercise_23_16");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        BubbleSort bubbleSort = new BubbleSort();
        hBoxForHistogram.setArray(bubbleSort.getArray());
        hBoxForHistogram.repaintHistogram();
        
        btStep.setOnAction(e -> {
            if(bubbleSort.oneStepOfSort()) {
                hBoxForHistogram.repaintHistogram();
                hBoxForHistogram.getRectangles()[bubbleSort.getIndex()].setFill(Color.BLUE);
            }
            else {
                lbStatus.setText("The bubble sort has finished");
                hBoxForHistogram.getRectangles()[bubbleSort.getIndex()].setFill(Color.TRANSPARENT);
            }
        });
        
        btReset.setOnAction(e -> {
            bubbleSort.reset();
            hBoxForHistogram.repaintHistogram();
            lbStatus.setText("");
        });
    }
    
    class BubbleSort {
        private int[] array = new int[SIZE];
        private int k = 1;
        private int i = 0;
        
        public BubbleSort() {
            createArray();
            shuffleArray();
        }
        
        public int[] getArray() {
            return array;
        }

        public int getIndex() {
            return i;
        }
        
        public void createArray() {
            for(int i = 0; i < 20; i++) {
                array[i] = i + 1;
            }
        }
        
        public void shuffleArray() {
            for(int i = 0; i < array.length; i++) {
                int index = (int)(Math.random() * SIZE);
                if(index != i) {
                    int temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
        
        public void reset() {
            k = 1;
            i = 0;
            createArray();
            shuffleArray();
        }
        
        public boolean oneStepOfSort() {
            if(k < array.length) {
                if(i < array.length - k) {
                    if(array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                    i++;
                }
                else {
                    k++;
                    i = 0;
                }
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    class HBoxForHistogram extends HBox {
        private int[] array;
        private Rectangle[] rectangles = new Rectangle[SIZE];
        private Label[] lbChart = new Label[SIZE];
        
        public void setArray(int[] array) {
            this.array = array;
        }

        public Label[] getLbChart() {
            return lbChart;
        }
        
        public Rectangle[] getRectangles() {
            return rectangles;
        }
        
        public void repaintHistogram() {
            getChildren().clear();
            int j = 0;
            for(Integer i : array) {
                rectangles[j] = new Rectangle(23, i * 10);
                rectangles[j].setStroke(Color.BLACK);
                rectangles[j].setFill(Color.TRANSPARENT);
                lbChart[j] = new Label(i + "", rectangles[j]);
                lbChart[j].setContentDisplay(ContentDisplay.BOTTOM);
                getChildren().add(lbChart[j]);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
