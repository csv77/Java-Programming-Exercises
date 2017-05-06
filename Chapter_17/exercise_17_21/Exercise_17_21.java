package exercise_17_21;

import exercise_17_17.BitOutputStream;
import exercise_17_20.EditorPane;
import exercise_17_20.Exercise_17_20;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise_17_21 extends Application {
    private EditorPane pane = new EditorPane();
    private File file;
    
    @Override
    public void start(Stage primaryStage) {
        pane.getTfFilePath().setOnAction(e -> viewFile());
        pane.getBtChange().setOnAction(e -> editFile());
                
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_17_21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void viewFile() {
        file = new File("Chapter_17/" + pane.getTfFilePath().getText());
        try {
            try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
                int value;
                String hex = "";
                while((value = input.read()) != -1) {
                    hex += Integer.toHexString(value).toUpperCase();
                }
                pane.getTaEditorWindow().setText(hex);
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
        String hex = pane.getTaEditorWindow().getText().toUpperCase();
        try {
            try(BitOutputStream out = new BitOutputStream(file)) {
                for(int i = 0; i < hex.length() - 1; i += 2) {
                    int decimal = hexToDecimal(hex.substring(i, i + 2));
                    String binary = Exercise_17_20.getBits(decimal);
                    out.writeBit(binary);
                }
            }
        }
        catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        catch (IOException e) {
            System.out.println("Error during saving!");
        }
    }
    
    public int hexToDecimal(String hex) throws NumberFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if(!(hexChar >= 'A' && hexChar <= 'F') && !(hexChar >= '0' && hexChar <= '9')){
                throw new NumberFormatException("Not a hex number.");
            }
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    
    public int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        }
        else {
            return ch - '0';
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
