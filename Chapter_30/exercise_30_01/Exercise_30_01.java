package exercise_30_01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise_30_01 extends Application {
    private TextArea taThreads = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        ScrollPane pane = new ScrollPane(taThreads);
        taThreads.setWrapText(true);
        pane.fitToWidthProperty();
        
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        Scene scene = new Scene(pane, 490, 150);
        primaryStage.setTitle("Exercise_31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class PrintChar implements Runnable {
        private char charToPrint;
        private int times;

        public PrintChar(char charToPrint, int times) {
            this.charToPrint = charToPrint;
            this.times = times;
        }
        
        @Override
        public void run() {
            for(int i = 0; i < times; i++) {
                Platform.runLater(() -> {
                    taThreads.appendText("" + charToPrint);
                });
            }
        }
    }
    
    class PrintNum implements Runnable {
        private int lastNum;

        public PrintNum(int lastNum) {
            this.lastNum = lastNum;
        }

        @Override
        public void run() {
            for(int i = 0; i < lastNum; i++) {
                int j = i;
                Platform.runLater(() -> {
                    taThreads.appendText(" " + j);
                });
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
