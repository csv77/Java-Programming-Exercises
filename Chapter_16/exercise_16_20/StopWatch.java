package exercise_16_20;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class StopWatch extends StackPane {
    private int hour;
    private int min;
    private int sec;
    private Timeline animation;
    private Text text = new Text();
    
    public StopWatch() {
        setPadding(new Insets(15, 5, 15, 5));
        clear();
        getChildren().add(text);
        text.setFont(Font.font(30));
        animation = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            run();
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }
    
    public void run() {
        if(min == 59 && sec == 59) {
            hour++;
            min = 0;
            sec = 0;
        }
        if(sec == 59) {
            if(min == 59) {
                min = 0;
            }
            else {
                min++;
            }    
        }
        sec = (sec < 59 ? sec + 1 : 0);
        text.setText(getTime());
    }
    
    public void clear() {
        hour = 0;
        min = 0;
        sec = 0;
        text.setText(getTime());
    }
    
    public String getTime() {
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}
