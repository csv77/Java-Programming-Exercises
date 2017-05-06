package exercise_17_20;

import exercise_17_17.BitOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_17_20 extends Application {
    private EditorPane pane = new EditorPane();
    private File file;
    
    @Override
    public void start(Stage primaryStage) {
        pane.getTfFilePath().setOnAction(e -> viewFile());
        pane.getBtChange().setOnAction(e -> editFile());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_17_20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void viewFile() {
        file = new File("Chapter_17/" + pane.getTfFilePath().getText());
        try {
            try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
                int value;
                String binary = "";
                while((value = input.read()) != -1) {
                    binary += getBits(value);
                }
                pane.getTaEditorWindow().setText(binary);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("Loading error!");
        }
    }
    
    public void editFile() {
        try {
            try(BitOutputStream out = new BitOutputStream(file)) {
                String binary = pane.getTaEditorWindow().getText();
                out.writeBit(binary);
            }
        }
        catch (IOException e) {
            System.out.println("Error during saving!");
        }
    }
    
    public static String getBits(int value) {
        value = (value << 24) >> 24;
        String binary = Integer.toBinaryString(value);
        for(int i = 0; i < 8 - binary.length(); i++) {
            binary = "0" + binary;
        }
        return binary;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
