package exercise_17_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_17_13 extends Application {
    private CombinePane pane = new CombinePane();
    
    @Override
    public void start(Stage primaryStage) {
        pane.getBtStart().setOnAction(e -> combineFiles());
        
        Scene scene = new Scene(pane, 350, 130);
        primaryStage.setTitle("Exercise_17_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void combineFiles() {
        RandomAccessFile[] files = new RandomAccessFile[Integer.parseInt(pane.getNumberOfFiles().getText())];
        
        try {
            try(RandomAccessFile target = new RandomAccessFile("Chapter_17/" + pane.getFileName().getText(), "rw")) {
                for(int i = 0; i < files.length; i++) {
                        files[i] = new RandomAccessFile("Chapter_17/" + pane.getFileName().getText() + "." + (i + 1), "r");
                        byte[] bytes = new byte[(int)files[i].length()];
                        files[i].seek(0);
                        files[i].read(bytes);
                        target.seek(target.length());
                        target.write(bytes);
                        files[i].close();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
