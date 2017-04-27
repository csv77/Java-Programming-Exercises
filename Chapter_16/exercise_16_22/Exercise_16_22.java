package exercise_16_22;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Exercise_16_22 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button play = new Button("Play");
        Button loop = new Button("Loop");
        Button stop = new Button("Stop");
        
        HBox paneForButtons = new HBox(5);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.getChildren().addAll(play, loop, stop);
        paneForButtons.setPadding(new Insets(10, 15, 10, 15));
        
        MediaPlayer audio = new MediaPlayer(new Media("http://cs.armstrong.edu/liang/common/audio/anthem/anthem6.mp3"));
        
        play.setOnAction(e -> {
            if(!audio.getStatus().equals("PLAYING")) {
                audio.setCycleCount(1);
                audio.play();
            }
        });
        
        loop.setOnAction(e -> {
            if(!audio.getStatus().equals("PLAYING")) {
                audio.setCycleCount(Timeline.INDEFINITE);
                audio.play();
            }
        });
        
        stop.setOnAction(e -> {
            audio.stop();
        });
        
        Scene scene = new Scene(paneForButtons);
        primaryStage.setTitle("Exercise_16_22");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
