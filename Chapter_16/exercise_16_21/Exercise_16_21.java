package exercise_16_21;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_16_21 extends Application {
    private Timeline animation;
    private TextField countDown = new TextField();
    private Media media = new Media("http://cs.armstrong.edu/liang/common/audio/anthem/anthem6.mp3");
    private MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(15, 5, 15, 5));
        
        countDown.setPrefColumnCount(3);
        countDown.setAlignment(Pos.CENTER);
        countDown.setFont(Font.font("Arial", 20));
        pane.getChildren().add(countDown);
        
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e ->{
                int time = Integer.parseInt(countDown.getText());
                if(time > 0) {
                    decrementText();
                }
                else {
                    playMusic();
                }
            }));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        countDown.setOnAction(e -> {
            countDown.setCursor(Cursor.TEXT);
            animation.play();
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void decrementText() {
        countDown.setText("" + (Integer.parseInt(countDown.getText()) - 1));
    }
    
    protected void playMusic() {
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
