package exercise_23_17;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_23_17 extends Application {
    private static final int DIGITS = 10;
    private static final int SIZE = 20;
    private static final int INTERVAL = 1000;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        RadixSortControl radixSortControl = new RadixSortControl((int)Math.log10(INTERVAL));
        
        VBoxForBuckets vBoxForBuckets = new VBoxForBuckets(radixSortControl.getNumbers());
        vBoxForBuckets.setStyle("-fx-border-color : black");
        vBoxForBuckets.repaintBuckets();
        
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        
        HBox hBoxForButtons = new HBox();
        hBoxForButtons.setSpacing(5);
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.getChildren().addAll(btStep, btReset);
        
        Label lbStatus = new Label();
        
        borderPane.setBottom(hBoxForButtons);
        borderPane.setCenter(vBoxForBuckets);
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 700, 400);
        primaryStage.setTitle("Exercise_23_17");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btStep.setOnAction(e -> {
            switch(radixSortControl.step()) {
                case "ONE ITEM IS IN BUCKET" :
                    int j = radixSortControl.getJ() - 1;
                    int temp = radixSortControl.getTemp();
                    int number = radixSortControl.getNumbers()[j];
                    vBoxForBuckets.setFontColor(j); 
                    vBoxForBuckets.getBuckets()[temp].getChildren().add(new Label(number + ""));
                    break;
                case "ALL ITEMS ARE IN BUCKETS" :
                    vBoxForBuckets.setNumbers(radixSortControl.getNumbers());
                    vBoxForBuckets.repaintBuckets();
                    vBoxForBuckets.clearBuckets();
                    break;
                case "FINISH" :
                    vBoxForBuckets.setNumbers(radixSortControl.getNumbers());
                    vBoxForBuckets.repaintBuckets();
                    vBoxForBuckets.clearBuckets();
                    lbStatus.setText("The array is now sorted. Press Reset for a new array.");
                    break;
            }
        });
        
        btReset.setOnAction(e -> {
            lbStatus.setText("");
            radixSortControl.reset();
            vBoxForBuckets.repaintBuckets();
        });
    }
    
    class VBoxForBuckets extends VBox {
        private VBox[] buckets = new VBox[DIGITS];
        private Rectangle[] rectangles = new Rectangle[SIZE];
        private Label[] lbBuckets = new Label[DIGITS];
        private Label[] lbNumbers = new Label[SIZE];
        private int[] numbers;
        private HBox hBoxForBuckets = new HBox(2);
        private HBox hBoxForRectangles = new HBox();

        public VBoxForBuckets(int[] numbers) {
            this.numbers = numbers;
        }
        
        public VBox[] getBuckets() {
            return buckets;
        }

        public void setNumbers(int[] numbers) {
            this.numbers = numbers;
        }
        
        public void repaintBuckets() {
            this.getChildren().clear();
            hBoxForBuckets.getChildren().clear();
            hBoxForRectangles.getChildren().clear();
            for(int i = 0; i < SIZE; i++) {
                rectangles[i] = new Rectangle(25, 15);
                rectangles[i].setFill(Color.TRANSPARENT);
                rectangles[i].setStroke(Color.BLACK);
                lbNumbers[i] = new Label(numbers[i] + "");
                lbNumbers[i].setGraphic(rectangles[i]);
                lbNumbers[i].setContentDisplay(ContentDisplay.CENTER);
                hBoxForRectangles.getChildren().add(lbNumbers[i]);
                hBoxForRectangles.setAlignment(Pos.CENTER);
            }
            for(int i = 0; i < DIGITS; i++) {
                buckets[i] = new VBox();
                buckets[i].setStyle("-fx-border-color : black");
                buckets[i].setPrefSize(35, 200);
                lbBuckets[i] = new Label("bucket[" + i + "]");
                lbBuckets[i].setGraphic(buckets[i]);
                lbBuckets[i].setContentDisplay(ContentDisplay.TOP);
                hBoxForBuckets.getChildren().add(lbBuckets[i]);
                hBoxForBuckets.setAlignment(Pos.CENTER);
            }
            this.getChildren().addAll(hBoxForRectangles, hBoxForBuckets);
            this.setAlignment(Pos.CENTER);
            this.setSpacing(10);
        }
        
        public void clearBuckets() {
            for(int i = 0; i < DIGITS; i++) {
                buckets[i].getChildren().clear();
            }
        }
        
        public void setFontColor(int n) {
            for(int i = 0; i < SIZE; i++) {
                if(i != n) {
                    lbNumbers[i].setStyle("-fx-text-fill : black");
                }
                else {
                    lbNumbers[n].setStyle("-fx-text-fill : red");
                }
            }
        }
    }
    
    public class RadixSortControl {
        private int[] numbers = new int[SIZE];
        private ArrayList<Integer>[] bucketsList = new ArrayList[DIGITS];
        private int numberOfDigits;
        private int j;
        private int m;
        private int temp;
        
        public RadixSortControl(int numberOfDigits) {
            int j = 0, temp = 0;
            this.numberOfDigits = numberOfDigits;
            this.m = numberOfDigits;
            createNumbers();
            for(int i = 0; i < bucketsList.length; i++) {
                bucketsList[i] = new ArrayList<>();
            }
        }

        public int getJ() {
            return j;
        }

        public int getTemp() {
            return temp;
        }

        public int[] getNumbers() {
            return numbers;
        }
        
        protected void createNumbers() {
            for(int i = 0; i < SIZE; i++) {
                numbers[i] = (int)(Math.random() * INTERVAL);
            }
        }
        
        public void reset() {
            createNumbers();
            m = numberOfDigits;
            j = 0;
            temp = 0;
        }
        
        public String step() {
            if(m == 0) {
                return "FINISH";
            }
            if(j < numbers.length) {
                temp = (numbers[j] / (int)(Math.pow(10, numberOfDigits - m))) % 10;
                bucketsList[temp].add(numbers[j]);
                j++;
                return "ONE ITEM IS IN BUCKET";
            }
            else {
                m--;
                j = 0;
                int k = 0;
                for(int l = 0; l < bucketsList.length; l++) {
                    for(int n = 0; n < bucketsList[l].size(); n++) {
                        numbers[k++] = bucketsList[l].get(n);
                    }
                }
                for(int l = 0; l < bucketsList.length; l++) {
                    bucketsList[l].clear();
                }
                return "ALL ITEMS ARE IN BUCKETS";
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
