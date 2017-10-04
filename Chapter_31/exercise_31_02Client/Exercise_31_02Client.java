package exercise_31_02Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_31_02Client extends Application {
    private DataInputStream inputFromServer = null;
    private DataOutputStream outputToServer = null;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        
        TextArea taStatus = new TextArea();
        borderPane.setCenter(new ScrollPane(taStatus));
        
        GridPane grid = new GridPane();
        
        TextField tfWeight = new TextField();
        tfWeight.setAlignment(Pos.BASELINE_RIGHT);
        tfWeight.setPrefColumnCount(10);
        
        TextField tfHeight = new TextField();
        tfHeight.setAlignment(Pos.BASELINE_RIGHT);
        tfHeight.setPrefColumnCount(10);
        
        Button btSubmit = new Button("Submit");
        
        grid.add(new Label("Weight in kgs"), 0, 0);
        grid.add(tfWeight, 1, 0);
        grid.add(new Label("Height in meters"), 0, 1);
        grid.add(tfHeight, 1, 1);
        grid.add(btSubmit, 2, 1);
        borderPane.setTop(grid);
        
        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("Exercise_31_02Client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        try {
            Socket socket = new Socket("localhost", 8000);
            inputFromServer = new DataInputStream(socket.getInputStream());
            outputToServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            taStatus.appendText(ex.toString() + "\n");
        }
        
        btSubmit.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(tfWeight.getText().trim());
                double height = Double.parseDouble(tfHeight.getText().trim());
                
                outputToServer.writeDouble(weight);
                outputToServer.writeDouble(height);
                outputToServer.flush();
                
                taStatus.appendText("Weight: " + weight + "\n" + "Height: " + height + "\n");
                
                String status = inputFromServer.readUTF();
                taStatus.appendText(status + "\n");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
