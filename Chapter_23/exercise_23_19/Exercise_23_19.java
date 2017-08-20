package exercise_23_19;

import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_23_19 extends Application {
    private static final int SIZE = 20;
    private static final int INTERVAL = 999;
    private int[] list = new int[SIZE];
    private int first = 0;
    private int last = SIZE - 1;
    private int low;
    private int high;
    private int pivotIndex = 0;
    private int pivot;
    private Stack<Integer> stack = new Stack<>();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        createList();
        QuickSortPane pane = new QuickSortPane();
        pane.repaint();
        
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        HBox hBoxForButtons = new HBox(5);
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.getChildren().addAll(btStep, btReset);
        
        Label lbStatus = new Label();
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        borderPane.setCenter(pane);
        borderPane.setBottom(hBoxForButtons);
        
        Scene scene = new Scene(borderPane, 550, 250);
        primaryStage.setTitle("Exercise_23_19");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btStep.setOnAction(e -> {
            if(quickSortControl() == 1) {
                pane.repaint();
            }
            else {
                lbStatus.setText("The array is already sorted.");
            }
        });
        
        btReset.setOnAction(e -> {
            first = 0;
            last = SIZE - 1;
            pivotIndex = 0;
            createList();
            pane.repaint();
            lbStatus.setText("");
        });
    }
    
    public void createList() {
        for(int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * INTERVAL + 1);
            pivot = list[pivotIndex];
            low = first + 1;
            high = last;
        }
    }
    
    public int quickSortControl() {
        if(high > low) {
            if(low <= high && list[low] <= pivot) {
                low++;
                return 1;
            }
            else if(low <= high && list[high] > pivot) {
                high--;
                return 1;
            }

            if(high > low) {
                swap(list, low, high);
                return 1;
            }
        }

        if(high > first && list[high] >= pivot) {
            high--;
            return 1;
        }
        
        if(pivot > list[high]) {
            swap(list, pivotIndex, high);
            int temp = high;
            high = pivotIndex;
            pivotIndex = temp;
        }
        else {
            pivot = list[first];
            pivotIndex = first;
        }
        
        if(pivotIndex - 1 >= first) {
            stack.push(first);
            stack.push(pivotIndex - 1);
        }
        if(pivotIndex + 1 < last) {
            stack.push(pivotIndex + 1);
            stack.push(last);
        }

        if(!stack.isEmpty()) {
            last = stack.pop();
            first = stack.pop();
            pivotIndex = first;
            low = first + 1;
            high = last;
            pivot = list[first];
            return 1;
        }    
        return 2;
    }
    
    public void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    class QuickSortPane extends Pane {
        private int x = 20;
        private int y = 100;
        private double width = 25;
        private double height = 15;
        
        public QuickSortPane() {
            this.setStyle("-fx-border-color : black");
        }
        
        public void repaint() {
            getChildren().clear();
            
            for(int i = 0; i < list.length; i++) {
                Rectangle rectangle = new Rectangle(x + i * width, y, width, height);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                Text text = new Text(x + 3 + i * width, y + 12, list[i] + "");
                getChildren().addAll(rectangle, text);
            }
            
            drawArrow(20, 32.5 + low * width, y, true);
            drawArrow(40, 32.5 + high * width, y, true);
            drawArrow(40, 32.5 + pivotIndex * width, y + 15, false);
            Text tLow = new Text(25 + low * width, y - 20, "low");
            Text tHigh = new Text(25 + high * width, y - 40, "high");
            Text tPivot = new Text(25 + pivotIndex * width, y + 65, "pivot");
            
            getChildren().addAll(tLow, tHigh, tPivot);
        }
        
        public void drawArrow(double length, double x1, double y1, boolean down) {
            if(down) {
                Polyline polyline = new Polyline(x1 - 5, y1 - 5, x1, y1, x1 + 5, y1 - 5);
                Line line = new Line(x1, y1, x1, y1 - length);
                getChildren().addAll(polyline, line);
            }
            else {
                Polyline polyline = new Polyline(x1 - 5, y1 + 5, x1, y1, x1 + 5, y1 + 5);
                Line line = new Line(x1, y1, x1, y1 + length);
                getChildren().addAll(polyline, line);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
