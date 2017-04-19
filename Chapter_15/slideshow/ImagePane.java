package slideshow;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ImagePane extends Pane{
        private Timeline animation;
        private int x = 1;
        
    public ImagePane() {
        getSlide();
        animation = new Timeline(new KeyFrame(Duration.seconds(2), e -> nextSlide()));
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
        getChildren().add(new ImageView(new Image("wallpapers/slide0" + x + ".jpg")));
    }
    
    public void nextSlide() {
        if(x < 7) {
            x++;
        }
        else {
            x = 1;
        }
        getSlide();
    }
    
}
