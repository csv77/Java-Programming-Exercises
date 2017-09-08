package exercise_27_06;

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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_27_06 extends Application {
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
        
        map.put(5, 5);
        map.put(10, 10);
        map.put(11, 11);
        
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
                if(map.containsKey(key)) {
                    lbStatus.setText(key + " is in the set.");
                }
                else {
                    lbStatus.setText(key + " is not in the set.");
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfKey.getText() + " is not in the set.");
            }
        });
        
        btInsert.setOnAction(e -> {
            try {
                Integer key = Integer.parseInt(tfKey.getText());
                if(map.get(key) != null) {
                    lbStatus.setText(key + " is already in the set.");
                    hashPane.displayHash();
                }
                else {
                    map.put(key, key);
                    lbStatus.setText(key + " was put in the set.");
                    hashPane.displayHash();
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfKey.getText() + " is not an integer.");
            }
        });
        
        btRemoveAll.setOnAction(e -> {
            map.clear();
            lbStatus.setText("All element was removed from the set.");
            hashPane.displayHash();
        });
        
        btRemove.setOnAction(e -> {
            try {
                Integer key = Integer.parseInt(tfKey.getText());
                if(map.get(key) != null) {
                    map.remove(key);
                    lbStatus.setText(key + " was removed from the set.");
                    hashPane.displayHash();
                }
                else {
                    lbStatus.setText(key + " is not in the set.");
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
                if((float)map.size() / capacity >= map.getLoadFactorThreshold()) {
                    System.out.println((float)map.size() / capacity);
                    lbStatus.setText("Number of keys / size must be higher than threshold.");
                }
                else {
                    Set<MyMap.Entry<Integer, Integer>> entrySet = map.entrySet();
                    map = new MyHashMap<Integer, Integer>(capacity);
                    for(MyMap.Entry<Integer, Integer> entry : entrySet) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                    hashPane.displayHash();
                    lbStatus.setText("Map size was modified to " + capacity + ".");
                }
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfInitialTableSize.getText() + " is not an integer.");
            }
        });
        
        tfLoadFactorThreshold.setOnAction(e -> {
            try {
                Float threshold = Float.parseFloat(tfLoadFactorThreshold.getText());
                Set<MyMap.Entry<Integer, Integer>> entrySet = map.entrySet();
                int capacity = map.getCapacity();
                map = new MyHashMap<Integer, Integer>(capacity, threshold);
                for(MyMap.Entry<Integer, Integer> entry : entrySet) {
                    map.put(entry.getKey(), entry.getValue());
                }
                lbStatus.setText("Threshold was modified to " + threshold + ".");
                hashPane.displayHash();
            }
            catch (NumberFormatException ex) {
                lbStatus.setText(tfLoadFactorThreshold.getText() + " is not a float.");
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
                    tKey = new Text(x + 15, y + i * height + 15, map.table[i].getValue() + "");
                }
                Text tIndex = new Text(x - 25, y + i * height + 15, "[" + i + "]");
                
                getChildren().addAll(rectangle, tIndex, tKey);
            }
            setStatus();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
