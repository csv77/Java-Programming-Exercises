package exercise_16_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Histogram extends Pane {
    private char[] chars = new char[26];
    private int[] counts = new int[26];
    private Rectangle[] bars = new Rectangle[26];
    private GridPane pane;
    private File file;
    private double width = 300;
    private double height = 200;
    
    public Histogram(String filename) {
        this.file = new File(filename.trim());
        setWidth(width);
        setHeight(height);
        readFile();
        draw();
    }
    
    public void readFile() {
        String text = "";
        if(!file.exists()) {
            System.out.println("The file " + file.getName() + " is not exists!");
        }
        else {
            try(Scanner input = new Scanner(file)) {
                while(input.hasNext()) {
                    text += input.nextLine();
                }
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        }
        text = text.toUpperCase();
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(Character.isLetter(c)) {
                counts[c - 'A']++;
            }
        }
    }
    
    public void draw() {
        pane = new GridPane();
        double total = 0;
        for(int i : counts) {
            total += i;
        }
        for(int i = 0; i < chars.length; i++) {
            chars[i] = (char)('A' + i);
            double percentage = counts[i] / total;
            bars[i] = new Rectangle(width / chars.length, height * percentage);
            bars[i].setFill(Color.WHITE);
            bars[i].setStroke(Color.BLACK);
            Label label = new Label((chars[i]) + "", bars[i]);
            label.setContentDisplay(ContentDisplay.TOP);
            pane.add(label, i, 0);
            GridPane.setValignment(label, VPos.BOTTOM);
        }
        
        getChildren().addAll(pane);
    }
}
