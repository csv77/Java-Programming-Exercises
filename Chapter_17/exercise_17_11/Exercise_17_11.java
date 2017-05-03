package exercise_17_11;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_17_11 extends Application {
    private SplitPane pane = new SplitPane();
        
    @Override
    public void start(Stage primaryStage) {
        pane.getBtStart().setOnAction(e -> splitter());
        
        Scene scene = new Scene(pane, 350, 130);
        primaryStage.setTitle("Exercise_17_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void splitter() {
        int numberOfPieces = Integer.parseInt(pane.getNumberOfFiles().getText());
        File file = new File("Chapter_17/" + pane.getFileName().getText());
        
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
                    pane.getFileName().getText() + "." + number))) {
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
