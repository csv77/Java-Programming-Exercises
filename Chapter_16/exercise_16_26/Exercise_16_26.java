package exercise_16_26;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_16_26 extends Application {
    private static final String URL = "http://cs.armstrong.edu/liang/common/audio/anthem/anthem6.mp3";
    
    @Override
    public void start(Stage primaryStage) {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(URL));
        Pane pane = new Pane();
        ImageView flag = new ImageView(new Image("image/us.gif"));
        
        
        pane.setOnMouseClicked(e -> {
            pane.getChildren().add(flag);
            mediaPlayer.play();
            double time = mediaPlayer.getStopTime().toMillis();
            System.out.println(time);
            PathTransition ptFlag = new PathTransition(Duration.millis(time), new Line(100, 300, 100, 50), flag);
            ptFlag.play();
        });
        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_16_26");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
