package exercise_21_11;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_21_11 extends Application {
    private ComboBox<Integer> cbYear = new ComboBox<>();
    private ComboBox<String> cbGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Button btFindRanking = new Button("Find Ranking");
    private Label lbResult = new Label();
    private HashMap[] boys;
    private HashMap[] girls;
    
    @Override
    public void start(Stage primaryStage) {
        boys = getData("M");
        girls = getData("F");
        
        btFindRanking.setOnAction(e -> getRanking());
        
        Scene scene = new Scene(paneForNames());
        primaryStage.setTitle("Exercise_21_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public BorderPane paneForNames() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        for(int i = 2001; i < 2011; i++) {
            cbYear.getItems().add(i);
        }
        cbYear.setValue(cbYear.getItems().get(0));
        
        cbGender.getItems().addAll("Male", "Female");
        cbGender.setValue(cbGender.getItems().get(0));
        
        tfName.setPrefColumnCount(15);
        
        gridPane.add(cbYear, 1, 0);
        gridPane.add(cbGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lbResult);
        borderPane.setPadding(new Insets(5));
        
        return borderPane;
    }
    
    public HashMap[] getData(String gender) {
        HashMap[] mapArray = new HashMap[10];
        for(int i = 0; i < 10; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            try {
                URL url = new URL("http://www.cs.armstrong.edu/liang/data/babynamesranking" + (i + 2001) + ".txt");
                Scanner input = new Scanner(url.openStream());
                while(input.hasNext()) {
                    ArrayList<String> list = new ArrayList<>();
                    for(int j = 0; j < 5; j++) {
                        list.add(input.next());
                    }
                    if(gender.equals("M")) {
                        map.put(list.get(1), Integer.parseInt(list.get(0)));
                    }
                    else if(gender.equals("F")) {
                        map.put(list.get(3), Integer.parseInt(list.get(0)));
                    }
                }
            }
            catch (MalformedURLException ex) {
                System.out.println("Invalid URL");
            }
            catch (IOException ex){
                System.out.println("I/O error: no such file");
            }
            mapArray[i] = map;
        }
        
        return mapArray;
    }
    
    public void getRanking() {
        int year = cbYear.getValue();
        String gender = cbGender.getValue();
        String name = tfName.getText();
        
        
    }
}
