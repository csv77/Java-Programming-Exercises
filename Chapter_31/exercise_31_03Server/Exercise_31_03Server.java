package exercise_31_03Server;

import exercise_17_06.Loan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

public class Exercise_31_03Server extends Application {
    private TextArea taStatus = new TextArea();
    private int clientNo = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = new Scene(new ScrollPane(taStatus), 400, 150);
        primaryStage.setTitle("Exercise_31_03Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> taStatus.appendText("Exercise_31_01Server started at " + new Date() + "\n"));
                
                
                while(true) {
                    Socket socket = serverSocket.accept();
                    clientNo++;
                    
                    Platform.runLater(() -> {
                        taStatus.appendText("Starting thread for client " + clientNo + " at " + new Date() + "\n");
                        InetAddress inetAddress = socket.getInetAddress();
                        taStatus.appendText("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + "\n");
                        taStatus.appendText("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
                    });
                    
                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
    private class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try{
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
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
