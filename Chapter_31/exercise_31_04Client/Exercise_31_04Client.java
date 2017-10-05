package exercise_31_04Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise_31_04Client extends Application {
    private Label lbl = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new BorderPane(lbl), 200, 50);
        primaryStage.setTitle("Exercise_31_04Client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        try {
            Socket socket = new Socket("localhost", 8000);
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            int count = inputFromServer.readInt();
            lbl.setText("You are visitor " + count);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
