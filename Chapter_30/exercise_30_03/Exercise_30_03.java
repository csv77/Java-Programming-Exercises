package exercise_30_03;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise_30_03 extends Application {
    private ImageView imageView = new ImageView("image/us.gif");
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.getChildren().add(imageView);
        imageView.setX(100);
        imageView.setY(200);
                
        new Thread(() -> {
            try {
                while(true) {
                    Platform.runLater(() -> setImageViewCoordinates());
                    Thread.sleep(10);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Exercise_30_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setImageViewCoordinates() {
        if(imageView.getY() > 0) {
            imageView.setY(imageView.getY() - 1);
        }
        else {
            imageView.setY(200);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
