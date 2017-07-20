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
    private TextField tfNames = new TextField();
    private Button btFindRanking = new Button("Find Ranking");
    private Label lbStatus = new Label();
    private HashMap[][] rankings;
    
    @Override
    public void start(Stage primaryStage) {
        rankings = getData();
        btFindRanking.setOnAction(e -> getRanking());
        
        Scene scene = new Scene(getPaneForRanking());
        primaryStage.setTitle("Exercise_21_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public BorderPane getPaneForRanking() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        for(int i = 2001; i <= 2010; i++) {
            cbYear.getItems().add(i);
        }
        cbYear.setValue(cbYear.getItems().get(0));
        
        cbGender.getItems().addAll("Male", "Female");
        cbGender.setValue(cbGender.getItems().get(0));
        
        tfNames.setPrefColumnCount(15);
        
        gridPane.add(cbYear, 1, 0);
        gridPane.add(cbGender, 1, 1);
        gridPane.add(tfNames, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lbStatus);
        
        return borderPane;
    }
    
    public HashMap[][] getData() {
        HashMap[][] mapArray = new HashMap[2][10];
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            HashMap<String, Integer> mapBoys = new HashMap<>();
            HashMap<String, Integer> mapGirls = new HashMap<>();
            try {
                URL url = new URL("http://www.cs.armstrong.edu/liang/data/babynamesranking" + (i + 2001) + ".txt");
                Scanner input = new Scanner(url.openStream());
                while(input.hasNext()) {
                    for(int j = 0; j < 5; j++) {
                        list.add(j, input.next());
                    }
                    mapBoys.put(list.get(1), Integer.parseInt(list.get(0)));
                    mapGirls.put(list.get(3), Integer.parseInt(list.get(0)));
                    list.clear();
                }
            }
            catch (MalformedURLException ex) {
                System.out.println("Invalid URL");
            }
            catch (IOException ex){
                System.out.println("I/O error: no such file");
            }
            mapArray[0][i] = mapBoys;
            mapArray[1][i] = mapGirls;
        }
        return mapArray;
    }
    
    public void getRanking() {
        int year = cbYear.getValue();
        int gender = (cbGender.getValue().equals("Male") ? 0 : 1);
        String name = tfNames.getText();
        int ranking;
        
        if(rankings[gender][year - 2001].containsKey(name)) {
            ranking = (Integer)rankings[gender][year - 2001].get(name);
            if(gender == 0) {
                lbStatus.setText("Boy name " + name + " is ranked #" + ranking + " in year " + year);
            }
            else if(gender == 1) {
                lbStatus.setText("Girl name " + name + " is ranked #" + ranking + " in year " + year);
            }
        }
        else if(gender == 0) {
            lbStatus.setText("The list of boys doesn't contain this name");
        }
        else if(gender == 1) {
            lbStatus.setText("The list of girls doesn't contain this name");
        }
    }
}
