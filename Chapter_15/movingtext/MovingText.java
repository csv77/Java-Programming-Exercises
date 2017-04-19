package movingtext;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingText extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 250);
        
        Text text = new Text("Programming is fun");
        Line line = new Line(-50, pane.getHeight() / 2, pane.getWidth() + 50, pane.getHeight() / 2);
        line.setStroke(Color.TRANSPARENT);
        line.setFill(Color.TRANSPARENT);
        pane.getChildren().addAll(line, text);
        
        PathTransition pt = new PathTransition(Duration.millis(3000), line, text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        
        primaryStage.setTitle("Control moving text");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
