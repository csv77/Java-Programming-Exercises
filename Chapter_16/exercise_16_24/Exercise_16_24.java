package exercise_16_24;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_16_24 extends Application {
    private static final String URL = "http://cs.armstrong.edu/liang/common/sample.mp4";
    private Slider slTime = new Slider();
    private String totalTime;
    
    @Override
    public void start(Stage primaryStage) {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(URL));
        MediaView mediaView = new MediaView(mediaPlayer);
        Label lbForTimeDisplay = new Label(getTimeFormat(0), slTime);
        
        Button btPlay = new Button(">");
        btPlay.setOnAction(e -> {
            if(btPlay.getText().equals(">")) {
                mediaPlayer.play();
                btPlay.setText("||");
                slTime.setMax(mediaPlayer.getTotalDuration().toMillis());
                totalTime = getTimeFormat(mediaPlayer.getTotalDuration().toMillis());
            }
            else {
                mediaPlayer.pause();
                btPlay.setText(">");
            }
        });
        System.out.println(totalTime);
        
        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));
        
        slTime.setPrefWidth(150);
        slTime.setMaxWidth(Region.USE_PREF_SIZE);
        slTime.setMinWidth(30);
        
        mediaPlayer.currentTimeProperty().addListener(e -> {
            if(!slTime.isValueChanging()) {
                slTime.setValue(mediaPlayer.getCurrentTime().toMillis());
            }
            lbForTimeDisplay.setText(getTimeFormat(mediaPlayer.getCurrentTime().toMillis()) + "/" + totalTime);
        });
        
        slTime.valueProperty().addListener(ov -> {
            if(slTime.isValueChanging()) {
                mediaPlayer.seek(new Duration(slTime.getValue()));
            }
        });
        
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPlay, new Label("Time"), lbForTimeDisplay, new Label("Volume"), slVolume);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);
        
        Scene scene = new Scene(pane, 650, 550);
        primaryStage.setTitle("Exercise_16_24");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public String getTimeFormat(double millis) {
        String time;
        long totalSec = (long)millis / 1000;
        String sec = String.format("%02d", totalSec % 60);
        long totalMin = totalSec / 60;
        String min = String.format("%02d", totalMin % 60);
        long totalHour = totalMin / 60;
        String hour = String.format("%02d", totalHour % 24);
        time = hour + ":" + min + ":" + sec;
        return time;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
