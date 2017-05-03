package exercise_17_11;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_17_11 extends Application {
    private TextField fileName = new TextField();
    private TextField numberOfFiles = new TextField();
    private Button btStart = new Button("Start");
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        GridPane paneForTextFields = new GridPane();
        paneForTextFields.setHgap(5);
        paneForTextFields.setVgap(5);
        
        paneForTextFields.add(new Label("Enter a file: "), 0, 0);
        paneForTextFields.add(fileName, 1, 0);
        paneForTextFields.add(new Label("Specify the number of smaller files: "), 0, 1);
        paneForTextFields.add(numberOfFiles, 1, 1);
        
        
        Label infotext = new Label("If you split a file named temp.txt into 3 smaller files,"
                + "the three smaller files are temp.txt.1, temp.txt.2 and temp.txt.3.");
        infotext.setWrapText(true);
        pane.setTop(infotext);
        pane.setCenter(paneForTextFields);
        pane.setBottom(btStart);
        BorderPane.setAlignment(btStart, Pos.CENTER);
        
        btStart.setOnAction(e -> splitter());
        
        Scene scene = new Scene(pane, 350, 130);
        primaryStage.setTitle("Exercise_17_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void splitter() {
        int numberOfPieces = Integer.parseInt(numberOfFiles.getText());
        File file = new File("Chapter_17/" + fileName.getText());
        
        try {
            try(RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                int lengthOfPiece = (int)(raf.length() / numberOfPieces);
                
                for(int i = 0; i < numberOfPieces; i++) {
                    raf.seek(i * lengthOfPiece);
                    if(i < numberOfPieces - 1) {
                        byte[] bytes = new byte[lengthOfPiece];
                        raf.read(bytes);
                        writeBytesInNewFile(bytes, i + 1);
                    }
                    else {
                        int lastPiece = (int)(raf.length() - (numberOfPieces - 1) * lengthOfPiece);
                        byte[] bytes = new byte[lastPiece];
                        raf.read(bytes);
                        writeBytesInNewFile(bytes, i + 1);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeBytesInNewFile(byte[] bytes, int number) {
        try {
            try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Chapter_17/" +
                    fileName.getText() + "." + number))) {
                output.write(bytes);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
