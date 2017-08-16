package exercise_23_10;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_23_10 extends Application {
    private Heap<Integer> heap = new Heap<>();
    private Button btInsert = new Button("Insert");
    private Button btRemoveRoot = new Button("Remove the root");
    private TextField tfInput = new TextField();
    private HeapPane heapPane = new HeapPane();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        tfInput.setPrefColumnCount(2);
        Label lbEnterKey = new Label("Enter a key:", tfInput);
        lbEnterKey.setContentDisplay(ContentDisplay.RIGHT);
        Label lbFormatError = new Label("Only number can be accepted!");
        
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lbEnterKey, btInsert, btRemoveRoot);
        
        pane.setBottom(hBox);
        pane.setCenter(heapPane);
        
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Exercise_23_10");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btInsert.setOnAction(e -> {
            try {
                hBox.getChildren().remove(lbFormatError);
                heap.add(Integer.parseInt(tfInput.getText()));
                heapPane.repaint();
            }
            catch(NumberFormatException ex) {
                hBox.getChildren().add(lbFormatError);
            }
        });
        
        btRemoveRoot.setOnAction(e -> {
            heap.remove();
            heapPane.repaint();
        });
    }
    
    class HeapPane extends Pane {
        private double vGap = 30;
        private double radius = 10;
        
        public void repaint() {
            this.getChildren().clear();
            displayHeap(0, getWidth() / 2, 20, getWidth() / 4);
        }
        
        public void displayHeap(int index, double x, double y, double hGap) {
            if(index < heap.getSize()) {
                Circle circle = new Circle(x, y, radius);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                getChildren().add(circle);
                Text text = new Text(circle.getCenterX() - radius * 0.5, y + radius * 0.5,
                        heap.list.get(index).toString());
                getChildren().add(text);
                
                int indexLeft = index * 2 + 1;
                int indexRight = index * 2 + 2;
                double alfa = Math.atan2(vGap, hGap / 2);
                
                if(indexLeft < heap.getSize()) {
                    drawLine(circle.getCenterX() - radius * Math.cos(alfa), circle.getCenterY() +
                            radius * Math.sin(alfa), x - hGap / 2 + radius * Math.cos(alfa), y + vGap - radius * Math.sin(alfa));
                }
                displayHeap(indexLeft, x - hGap / 2, y + vGap, hGap / 2);
                
                if(indexRight < heap.getSize()) {
                    drawLine(circle.getCenterX() + radius * Math.cos(alfa), circle.getCenterY() +
                            radius * Math.sin(alfa), x + hGap / 2 - radius * Math.cos(alfa), y + vGap - radius * Math.sin(alfa));
                }
                displayHeap(indexRight, x + hGap / 2, y + vGap, hGap / 2);
            }
        }
        
        public void drawLine(double x1, double y1, double x2, double y2) {
            Line line = new Line(x1, y1, x2, y2);
            getChildren().add(line);
        }
    }
    
    class Heap<E extends Comparable<E>> {
        private ArrayList<E> list = new ArrayList<>();

        public Heap() {
        }

        public Heap(E[] objects) {
            for(int i = 0; i < objects.length; i++) {
                add(objects[i]);
            }
        }

        public void add(E newObject) {
            list.add(newObject);
            int currentIndex = list.size() - 1;

            while(currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                }
                else {
                    break;
                }
                currentIndex = parentIndex;
            }
        }

        public E remove() {
            if(list.size() == 0) {
                return null;
            }

            E removedObject = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while(currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                if(leftChildIndex >= list.size()) {
                    break;
                }
                int maxIndex = leftChildIndex;
                if(rightChildIndex < list.size()) {
                    if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                        maxIndex = rightChildIndex;
                    }
                }

                if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                    E temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                }
                else {
                    break;
                }
            }
            return removedObject;
        }

        public int getSize() {
            return list.size();
    }
}


    public static void main(String[] args) {
        launch(args);
    }
    
}
