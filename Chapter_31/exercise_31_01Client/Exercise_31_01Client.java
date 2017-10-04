package exercise_31_01Client;

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

public class Exercise_31_01Client extends Application {
    private DataInputStream inputFromServer = null;
    private DataOutputStream outputToServer = null;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        
        TextArea taStatus = new TextArea();
        borderPane.setCenter(new ScrollPane(taStatus));
        
        GridPane grid = new GridPane();
        
        TextField tfRate = new TextField();
        tfRate.setAlignment(Pos.BASELINE_RIGHT);
        tfRate.setPrefColumnCount(10);
        
        TextField tfYears = new TextField();
        tfYears.setAlignment(Pos.BASELINE_RIGHT);
        tfYears.setPrefColumnCount(10);
        
        TextField tfAmount = new TextField();
        tfAmount.setAlignment(Pos.BASELINE_RIGHT);
        tfAmount.setPrefColumnCount(10);
        
        Button btSubmit = new Button("Submit");
        
        grid.add(new Label("Annual Interest Rate"), 0, 0);
        grid.add(tfRate, 1, 0);
        grid.add(new Label("Number Of Years"), 0, 1);
        grid.add(tfYears, 1, 1);
        grid.add(btSubmit, 2, 1);
        grid.add(new Label("Loan Amount"), 0, 2);
        grid.add(tfAmount, 1, 2);
        borderPane.setTop(grid);
        
        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("Exercise_31_01Client");
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
                double interestRate = Double.parseDouble(tfRate.getText().trim());
                int numberOfYears = Integer.parseInt(tfYears.getText().trim());
                double amount = Double.parseDouble(tfAmount.getText().trim());
                
                outputToServer.writeDouble(interestRate);
                outputToServer.writeInt(numberOfYears);
                outputToServer.writeDouble(amount);
                
                taStatus.appendText("Annual interest rate: " + interestRate + "\n" + 
                            "Number of Years: " + numberOfYears + "\n" + "Loan amount: " + amount + "\n");
                
                double monthlyPayment = inputFromServer.readDouble();
                double totalPayment = inputFromServer.readDouble();
                taStatus.appendText("monthlyPayment: " + monthlyPayment + "\n" + 
                            "totalPayment: " + totalPayment + "\n");
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
