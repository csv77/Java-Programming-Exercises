package exercise_31_05Server;

import exercise_31_05Client.Loan;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise_31_05Server extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea taStatus = new TextArea();
        
        Scene scene = new Scene(new ScrollPane(taStatus), 400, 150);
        primaryStage.setTitle("Exercise_31_05Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(6000);
                Platform.runLater(() -> taStatus.appendText("Exercise_31_01Server started at " + new Date() + "\n"));
                
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();
                Platform.runLater(() -> taStatus.appendText("Connected to a client at " + new Date() + "\n" + 
                        "Client IP address is " + inetAddress.getHostAddress() + "\n"));
                
                ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
                
                while(true) {
                    try {
                        Loan loan = (Loan)inputFromClient.readObject();
                        Platform.runLater(() -> taStatus.appendText("Annual interest rate: " + loan.getAnnualInterestRate() + "\n" + 
                                "Number of Years: " + loan.getNumberOfYears() + "\n" + "Loan amount: " + loan.getLoanAmount() + "\n"));

                        outputToClient.writeObject(loan);
                        outputToClient.flush();
                        Platform.runLater(() -> taStatus.appendText("monthlyPayment: " + loan.getMonthlyPayment() + "\n" + 
                                "totalPayment: " + loan.getTotalPayment()));
                    }
                    catch (ClassNotFoundException ex) {
                        taStatus.appendText(ex.toString() + "\n");
                    }
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
