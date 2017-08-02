package exercise_22_18;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_22_18 extends Application {
    private BorderPane borderPane = new BorderPane();
    private ArrayList<Integer> list;
    private Label[] lbChart = new Label[20];
    private Rectangle[] rectangles = new Rectangle[20];
    private HBox hBoxForChart = new HBox();
    
    @Override
    public void start(Stage primaryStage) {
        borderPane.setPadding(new Insets(5));
        Label lbResult = new Label();
        
        HBox hBoxForButtons = new HBox();
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.setSpacing(5);

        hBoxForChart.setAlignment(Pos.BOTTOM_CENTER);
        
        Label lbKey = new Label("Key(in double)");
        TextField tfKey = new TextField();
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        
        hBoxForButtons.getChildren().addAll(lbKey, tfKey, btStep, btReset);
        list = createArrayList();
        createHistogram();
        
        btStep.setOnAction(e -> {
            try {
                Double number = Double.parseDouble(tfKey.getText());
                int firstIndex = 0;
                int lastIndex = list.size() - 1;
                int index = -1;
                
                while(firstIndex <= lastIndex) {
                    int midIndex = (firstIndex + lastIndex) / 2;
                    if(number < (double)(list.get(midIndex))) {
                        lastIndex = midIndex - 1;
                    }
                    else if(number > (double)(list.get(midIndex))) {
                        firstIndex = midIndex + 1;
                    }
                    else {
                        index = midIndex;
                        break;
                    }
                }
                
                if(index != -1) {
                    lbResult.setText("The key is found in the array at index " + index);
                    for(int i = firstIndex; i <= lastIndex; i++) {
                        if(i == index) {
                            rectangles[index].setFill(Color.BLUE);
                        }
                        else {
                            rectangles[i].setFill(Color.LIGHTBLUE);
                        }
                    }
                }
                else {
                    lbResult.setText("The key is not in the array");
                    rectangles[rectangles.length - 1].setFill(Color.BLUE);
                }
                
                tfKey.setEditable(false);
            }
            catch (NumberFormatException ex) {
                lbResult.setText("Enter a number!");
            }
            
        });
        
        btReset.setOnAction(e -> {
            createHistogram();
            tfKey.setEditable(true);
        });
        
        borderPane.setTop(lbResult);
        BorderPane.setAlignment(lbResult, Pos.CENTER);
        borderPane.setBottom(hBoxForButtons);
        borderPane.setCenter(hBoxForChart);
        
        Scene scene = new Scene(borderPane, 500, 300);
        primaryStage.setTitle("Exercise_22_18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void createHistogram() {
        hBoxForChart.getChildren().clear();
        list = createArrayList();
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
    
}

