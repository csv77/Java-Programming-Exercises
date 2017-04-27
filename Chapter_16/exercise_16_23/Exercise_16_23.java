package exercise_16_23;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_16_23 extends Application {
    private TextField animationSpeed = new TextField();
    private TextField imageFilePrefix = new TextField();
    private TextField numberOfImages = new TextField();
    private TextField audioURL = new TextField();
    private Button btStartAnimation = new Button("Start Animation");
    private StackPane paneForGif = new StackPane();
    private Timeline animation;
    private int n = 1;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane paneForGui = setGui();
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            nextImage();
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        btStartAnimation.setOnAction(e -> {
            if(animationSpeed.getText().length() > 0) {
                animation.setRate(Integer.parseInt(animationSpeed.getText()));
            }
            animation.play();
            
            if(audioURL.getText().length() > 0) {
                MediaPlayer mediaPlayer = new MediaPlayer(new Media(audioURL.getText()));
                mediaPlayer.setCycleCount(Timeline.INDEFINITE);
                mediaPlayer.play();
            }
        });
        
        Scene scene = new Scene(paneForGui);
        primaryStage.setTitle("Exercise_16_23");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void getImages() {
        paneForGif.getChildren().clear();
        paneForGif.getChildren().add(new ImageView(new Image("image/" + imageFilePrefix.getText() + n + ".gif")));
    }
    
    public void nextImage() {
        if(n < Integer.parseInt(numberOfImages.getText())) {
            n++;
        }
        else {
            n = 1;
        }
        getImages();
    }
    
    public BorderPane setGui() {
        animationSpeed.setPrefColumnCount(40);
        imageFilePrefix.setPrefColumnCount(40);
        numberOfImages.setPrefColumnCount(40);
        audioURL.setPrefColumnCount(40);
        paneForGif.setMinSize(400, 400);
        
        GridPane paneForText = new GridPane();
        paneForText.add(new Label("Enter information for animation"), 0, 0);
        paneForText.add(new Label("Animation speed in milliseconds"), 0, 1);
        paneForText.add(new Label("Image file prefix"), 0, 2);
        paneForText.add(new Label("Number of images"), 0, 3);
        paneForText.add(new Label("Audio file URL"), 0, 4);
        paneForText.add(animationSpeed, 1, 1);
        paneForText.add(imageFilePrefix, 1, 2);
        paneForText.add(numberOfImages, 1, 3);
        paneForText.add(audioURL, 1, 4);
        
        HBox paneForButton = new HBox(btStartAnimation);
        paneForButton.setAlignment(Pos.TOP_RIGHT);
        
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForText);
        pane.setTop(paneForButton);
        pane.setCenter(paneForGif);
        
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
