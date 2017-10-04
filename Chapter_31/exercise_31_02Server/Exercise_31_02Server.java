package exercise_31_02Server;

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

public class Exercise_31_02Server extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea taStatus = new TextArea();
        
        Scene scene = new Scene(new ScrollPane(taStatus), 400, 150);
        primaryStage.setTitle("Exercise_31_02Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> taStatus.appendText("Exercise_31_02Server started at " + new Date() + "\n"));
                
                Socket socket = serverSocket.accept();
                Platform.runLater(() -> taStatus.appendText("Connected to a client at " + new Date() + "\n"));
                
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                
                while(true) {
                    double weight = inputFromClient.readDouble();
                    double height = inputFromClient.readDouble();
                    Platform.runLater(() -> taStatus.appendText("Weight: " + weight + "\n" + 
                            "Height: " + height + "\n"));
                    
                    BodyMassIndex BMI = new BodyMassIndex(weight, height);
                    String status = "BMI is " + String.format("%.2f", BMI.bmi) + ". " + BMI.getStatus();
                    
                    outputToClient.writeUTF(status);
                    Platform.runLater(() -> taStatus.appendText(status + "\n"));
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
    private class BodyMassIndex {
        double weight;
        double height;
        double bmi;

        public BodyMassIndex(double weight, double height) {
            this.weight = weight;
            this.height = height;
            bmi = weight / (Math.pow(height, 2));
        }
        
        public String getStatus() {
            if(bmi < 18.5) {
                return "Underweight";
            }
            else if(bmi < 25) {
                return "Normal";
            }
            else if(bmi < 30) {
                return "Overweight";
            }
            else {
                return "Obese";
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
