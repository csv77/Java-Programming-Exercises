package exercise_16_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TextPane extends Pane {
    private Timeline animation;
    private TextArea taSlide = new TextArea();
    private int x = 0;
        
    public TextPane(double preferredWidth, double preferredHeight) {
        taSlide.setWrapText(true);
        taSlide.setEditable(false);
        taSlide.setPrefSize(preferredWidth, preferredHeight);
        getSlide();
        animation = new Timeline(new KeyFrame(Duration.seconds(4), e -> getSlide()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }
    
    public void getSlide() {
        getChildren().clear();
        try {
            taSlide.setText(getTextFromFile("text/slide" + x + ".txt"));
            getChildren().add(taSlide);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
            
        if(x < 9) {
            x++;
        }
        else {
            x = 0;
        }
    }
    
    public String getTextFromFile(String url) throws FileNotFoundException {
        String text = "";
        File file = new File(url);
        if(!file.exists()) {
            System.out.println("File " + file.getName() + " is not exists.");
            System.exit(1);
        }
        
        try(Scanner input = new Scanner(file)) {
            while(input.hasNext()) {
                text += input.nextLine() + "\n";
            }
        }
        return text;
    }
}
