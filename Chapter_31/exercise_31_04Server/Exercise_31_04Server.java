package exercise_31_04Server;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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

public class Exercise_31_04Server extends Application {
    private TextArea taStatus = new TextArea();
    private int visitorCount;
    private RandomAccessFile raf;
    
    @Override
    public void start(Stage primaryStage) {
        taStatus.setWrapText(true);
        Scene scene = new Scene(new ScrollPane(taStatus), 370, 200);
        primaryStage.setTitle("Exercise_31_04Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        try {
            raf = new RandomAccessFile("visitorcount.dat", "rw");
            if(raf.length() == 0) {
                visitorCount = 0;
            }
            else {
                visitorCount = raf.readInt();
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> taStatus.appendText("Exercise_31_04Server started at " + new Date() + "\n"));
                
                int i = 0;
                while(true) {
                    int threadNumber = i;
                    Socket socket = serverSocket.accept();
                    InetAddress inetAddress = socket.getInetAddress();
                    
                    Platform.runLater(() -> taStatus.appendText("Starting thread " + threadNumber +
                            "\nClient IP /" + inetAddress.getHostAddress() + "\n"));
                    
                    new Thread(new HandleAClient(socket)).start();
                    i++;
                }
                
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
    public synchronized int modifyFile() {
        try {
            raf.seek(0);
            raf.writeInt(++visitorCount);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return visitorCount;
    }

    private class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try {
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                int i = modifyFile();
                outputToClient.writeInt(i);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
