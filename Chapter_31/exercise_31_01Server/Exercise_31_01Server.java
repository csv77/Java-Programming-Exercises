package exercise_31_01Server;

import exercise_17_06.Loan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise_31_01Server extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea taStatus = new TextArea();
        
        Scene scene = new Scene(new ScrollPane(taStatus), 400, 150);
        primaryStage.setTitle("Exercise_31_01Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> taStatus.appendText("Exercise_31_01Server started at " + new Date() + "\n"));
                
                Socket socket = serverSocket.accept();
                Platform.runLater(() -> taStatus.appendText("Connected to a client at " + new Date() + "\n"));
                
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                
                while(true) {
                    double interestRate = inputFromClient.readDouble();
                    int numberOfYears = inputFromClient.readInt();
                    double amount = inputFromClient.readDouble();
                    Platform.runLater(() -> taStatus.appendText("Annual interest rate: " + interestRate + "\n" + 
                            "Number of Years: " + numberOfYears + "\n" + "Loan amount: " + amount + "\n"));
                    
                    Loan loan = new Loan(interestRate, numberOfYears, amount);
                    
                    double monthlyPayment = loan.getMonthlyPayment();
                    double totalPayment = loan.getTotalPayment();
                    
                    outputToClient.writeDouble(monthlyPayment);
                    outputToClient.writeDouble(totalPayment);
                    Platform.runLater(() -> taStatus.appendText("monthlyPayment: " + monthlyPayment + "\n" + 
                            "totalPayment: " + totalPayment));
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
