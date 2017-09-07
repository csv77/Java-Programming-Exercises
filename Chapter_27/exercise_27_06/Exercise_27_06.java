package exercise_27_06;

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
        
        MyHashPane hashPane = new MyHashPane(map);
        ScrollPane scrollPane = new ScrollPane(hashPane);
        scrollPane.setStyle("-fx-border-color : black");
        borderPane.setCenter(scrollPane);
        hashPane.displayHash();
        
        HBox hBoxForHashFeatures = new HBox(10);
        hBoxForHashFeatures.setAlignment(Pos.CENTER);
        
        tfInitialTableSize.setPrefColumnCount(3);
        tfInitialTableSize.setAlignment(Pos.BASELINE_RIGHT);
        tfLoadFactorThreshold.setPrefColumnCount(3);
        tfLoadFactorThreshold.setAlignment(Pos.BASELINE_RIGHT);
        
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
        
        Scene scene = new Scene(borderPane, 600, 300);
        primaryStage.setTitle("Exercise_27_06");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btSearch.setOnAction(e -> {
            Integer key;
            try {
                key = Integer.parseInt(tfKey.getText());
                if(map.containsKey(key)) {
                    hashPane.tStatus.setText(key + " is in the set.");
                }
                else {
                    hashPane.tStatus.setText(key + " is not in the set.");
                }
            }
            catch (NumberFormatException ex) {
                hashPane.tStatus.setText(tfKey.getText() + " is not in the set.");
            }
        });
        
        btInsert.setOnAction(e -> {
            try {
                Integer key = Integer.parseInt(tfKey.getText());
                if(map.get(key) != null) {
                    hashPane.tStatus.setText(key + " is already in the set.");
                    hashPane.displayHash();
                }
                else {
                    map.put(key, key);
                    hashPane.displayHash();
                    hashPane.tStatus.setText("");
                }
            }
            catch (NumberFormatException ex) {
                hashPane.tStatus.setText(tfKey.getText() + " is not an integer.");
            }
        });
        
        btRemoveAll.setOnAction(e -> {
            map.clear();
            hashPane.displayHash();
        });
        
        btRemove.setOnAction(e -> {
            try {
                Integer key = Integer.parseInt(tfKey.getText());
                if(map.get(key) != null) {
                    map.remove(key);
                    hashPane.tStatus.setText("");
                    hashPane.displayHash();
                }
                else {
                    hashPane.tStatus.setText(key + " is not in the set.");
                    hashPane.displayHash();
                }
            }
            catch (NumberFormatException ex) {
                hashPane.tStatus.setText(tfKey.getText() + " is not an integer.");
            }
        });
        
        tfInitialTableSize.setOnAction(e -> {
            
        });
    }
    
    public class MyHashPane extends Pane {
        private MyHashMap<Integer, Integer> myMap;
        private int x = 40;
        private int y = 40;
        private int width = 40;
        private int height = 20;
        private Text tStatus;

        public MyHashPane(MyHashMap<Integer, Integer> myMap) {
            this.myMap = myMap;
            tStatus = new Text(x - 20, y + height * myMap.table.length + 20, "");
            setStatus();
        }
        
        public void setStatus() {
            int size = myMap.getCapacity();
            int numberOfKeys = myMap.size();
            float threshold = myMap.getLoadFactorThreshold();
            String text = new String("Current table size: " + size + ". Number of keys = " +
                    numberOfKeys + ". Current load: " + ((double)numberOfKeys / size) +
                    ". Load factor threshold: " + threshold);
            getChildren().addAll(new Text(x - 20, y - 20, text));
        }
        
        public void displayHash() {
            getChildren().clear();
            for(int i = 0; i < myMap.getCapacity(); i++) {
                Rectangle rectangle = new Rectangle(x, y + i * height, width, height);
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(Color.TRANSPARENT);
                
                Text tKey = new Text();
                
                if(myMap.table[i] != null) {
                    tKey = new Text(x + 15, y + i * height + 15, myMap.table[i].getValue() + "");
                }
                Text tIndex = new Text(x - 25, y + i * height + 15, "[" + i + "]");
                
                getChildren().addAll(rectangle, tIndex, tKey);
            }
            tStatus.setY(y + height * myMap.table.length + 20);
            getChildren().add(tStatus);
            setStatus();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
