package exercise_27_07;

import java.util.LinkedList;
import java.util.Set;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_27_07 extends Application {
    MyHashMap<Integer, Integer> map = new MyHashMap<>(4, 0.75f);
    Button btSearch = new Button("Search");
    Button btInsert = new Button("Insert");
    Button btRemove = new Button("Remove");
    Button btRemoveAll = new Button("Remove All");
    TextField tfKey = new TextField();
    TextField tfInitialTableSize = new TextField();
    TextField tfLoadFactorThreshold = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));
        
        MyHashPane hashPane = new MyHashPane();
        ScrollPane scrollPane = new ScrollPane(hashPane);
        scrollPane.setStyle("-fx-border-color : black");
        borderPane.setCenter(scrollPane);
        hashPane.displayHash();
        
        HBox hBoxForHashFeatures = new HBox(10);
        hBoxForHashFeatures.setAlignment(Pos.CENTER);
        
        tfInitialTableSize.setPrefColumnCount(3);
        tfInitialTableSize.setAlignment(Pos.BASELINE_RIGHT);
        tfInitialTableSize.setText(map.getCapacity() + "");
        tfLoadFactorThreshold.setPrefColumnCount(3);
        tfLoadFactorThreshold.setAlignment(Pos.BASELINE_RIGHT);
        tfLoadFactorThreshold.setText(map.getLoadFactorThreshold() + "");
        
        Label lbInitialTableSize = new Label("Enter Initial Table Size:", tfInitialTableSize);
        lbInitialTableSize.setContentDisplay(ContentDisplay.RIGHT);
        Label lbLoadFactorThreshold = new Label("Enter a Load Factor Threshold:", tfLoadFactorThreshold);
        lbLoadFactorThreshold.setContentDisplay(ContentDisplay.RIGHT);
        hBoxForHashFeatures.getChildren().addAll(lbInitialTableSize, lbLoadFactorThreshold);
        
        HBox hBoxForButtons = new HBox(10);
        hBoxForButtons.setAlignment(Pos.CENTER);
        
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        
        Label lbKey = new Label("Enter a key:", tfKey);
        lbKey.setContentDisplay(ContentDisplay.RIGHT);
        hBoxForButtons.getChildren().addAll(lbKey, btSearch, btInsert, btRemove);
        hBoxForButtons.setPadding(new Insets(5));
        hBoxForButtons.setStyle("-fx-border-color : black");
        
        HBox hBoxForAll = new HBox(5);
        hBoxForAll.getChildren().addAll(hBoxForButtons, btRemoveAll);
        hBoxForAll.setAlignment(Pos.CENTER);
        
        VBox vBoxForHBoxes = new VBox(5);
        vBoxForHBoxes.setPadding(new Insets(5));
        vBoxForHBoxes.getChildren().addAll(hBoxForHashFeatures, hBoxForAll);
        borderPane.setBottom(vBoxForHBoxes);
        
        Label lbStatus = new Label();
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setTitle("Exercise_27_06");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        tfKey.requestFocus();
        
        btSearch.setOnAction(e -> {
            Integer key;
            try {
                key = Integer.parseInt(tfKey.getText());
                if(map.getCapacity() > 0 && map.containsKey(key)) {
                    lbStatus.setText(key + " is in the map.");
                }
                else {
                    lbStatus.setText(key + " is not in the map.");
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfKey.getText() + " is not in the map.");
            }
        });
        
        btInsert.setOnAction(e -> {
            try {
                Integer key = Integer.parseInt(tfKey.getText());
                if(map.getCapacity() > 0 && map.get(key) != null) {
                    lbStatus.setText(key + " is already in the map.");
                    hashPane.displayHash();
                }
                else {
                    map.put(key, key);
                    lbStatus.setText(key + " was put in the map.");
                    hashPane.displayHash();
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfKey.getText() + " is not an integer.");
            }
        });
        
        btRemoveAll.setOnAction(e -> {
            map.clear();
            lbStatus.setText("All element was removed from the map.");
            hashPane.displayHash();
        });
        
        btRemove.setOnAction(e -> {
            try {
                Integer key = Integer.parseInt(tfKey.getText());
                if(map.get(key) != null) {
                    map.remove(key);
                    lbStatus.setText(key + " was removed from the map.");
                    hashPane.displayHash();
                }
                else {
                    lbStatus.setText(key + " is not in the map.");
                    hashPane.displayHash();
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfKey.getText() + " is not an integer.");
            }
        });
        
        tfInitialTableSize.setOnAction(e -> {
            try {
                Integer capacity = Integer.parseInt(tfInitialTableSize.getText());
                if(map.size() > capacity * map.getLoadFactorThreshold()) {
                    lbStatus.setText("Number of keys / capacity must be less than threshold.");
                }
                else if(capacity < 2) {
                    lbStatus.setText("Capacity cannot be less than 2.");
                }
                else {
                    Set<MyMap.Entry<Integer, Integer>> entrySet = map.entrySet();
                    float threshold = map.getLoadFactorThreshold();
                    map = new MyHashMap<Integer, Integer>(capacity, threshold);
                    for(MyMap.Entry<Integer, Integer> entry : entrySet) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                    hashPane.displayHash();
                    lbStatus.setText("Map capacity was modified to " + map.getCapacity() + ".");
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfInitialTableSize.getText() + " is not valid.");
            }
        });
        
        tfLoadFactorThreshold.setOnAction(e -> {
            try {
                Float threshold = Float.parseFloat(tfLoadFactorThreshold.getText());
                Set<MyMap.Entry<Integer, Integer>> entrySet = map.entrySet();
                Integer capacity = map.getCapacity();
                map = new MyHashMap<Integer, Integer>(capacity, threshold);
                for(MyMap.Entry<Integer, Integer> entry : entrySet) {
                    map.put(entry.getKey(), entry.getValue());
                }
                lbStatus.setText("Threshold was modified to " + map.getLoadFactorThreshold() + ".");
                hashPane.displayHash();
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfInitialTableSize.getText() + " or " + tfLoadFactorThreshold.getText() + " is not valid.");
            }
        });
    }
    
    public class MyHashPane extends Pane {
        private int x = 40;
        private int y = 40;
        private int width = 40;
        private int height = 20;
        
        public void setStatus() {
            int size = map.getCapacity();
            int numberOfKeys = map.size();
            float threshold = map.getLoadFactorThreshold();
            String text = new String("Current table size: " + size + ". Number of keys = " +
                    numberOfKeys + ". Current load: " + ((double)numberOfKeys / size) +
                    ". Load factor threshold: " + threshold);
            getChildren().addAll(new Text(x - 20, y - 20, text));
        }
        
        public void displayHash() {
            getChildren().clear();
            for(int i = 0; i < map.getCapacity(); i++) {
                Rectangle rectangle = new Rectangle(x, y + i * height, width, height);
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(Color.TRANSPARENT);
                
                Text tKey = new Text();
                
                if(map.table[i] != null) {
                    LinkedList<MyMap.Entry<Integer, Integer>> list = map.table[i];
                    int j = 0;
                    int arrowLength = 60;
                    for(MyMap.Entry<Integer, Integer> entry : list) {
                        Rectangle rectangle2 = new Rectangle(x + width * (0.5 + j) + arrowLength * (j + 1), y + i * height, width, height);
                        rectangle2.setStroke(Color.BLACK);
                        rectangle2.setFill(Color.TRANSPARENT);
                        drawArrow(rectangle2.getX() - arrowLength, rectangle2.getY() + height / 2, arrowLength);
                        tKey = new Text(rectangle2.getX() + 15, rectangle2.getY() + 15, entry.getValue() + "");
                        getChildren().addAll(rectangle2, tKey);
                        j++;
                    }
                }
                Text tIndex = new Text(x - 25, y + i * height + 15, "[" + i + "]");
                
                getChildren().addAll(rectangle, tIndex);
            }
            setStatus();
        }
        
        public void drawArrow(double x, double y, double length) {
            Line line = new Line(x, y, x + length, y);
            Line leftLine = new Line(line.getEndX(), line.getEndY(), line.getEndX() - 5, line.getEndY() - 5);
            Line rightLine = new Line(line.getEndX(), line.getEndY(), line.getEndX() - 5, line.getEndY() + 5);
            getChildren().addAll(line, leftLine, rightLine);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
