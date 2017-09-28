package exercise_30_03;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_30_03 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView("image/us.gif");
        Pane pane = new Pane();
        pane.getChildren().add(imageView);
        PathTransition pt = new PathTransition(Duration.millis(10000), new Line(100, 200, 100, 0), imageView);
        pt.setCycleCount(5);
        pt.play();
        
        new Thread(() -> {
            try {
                while(true) {
                    Platform.runLater(() -> pt.play());
                    Thread.sleep(1);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("Exercise_30_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
