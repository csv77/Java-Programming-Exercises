package animationpalindrome2;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationPalindrome2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle c = new Circle(10);
        c.setFill(Color.ORANGE);
        Arc a = new Arc(150, 150, 100, 50, 200, 140);
        a.setStroke(Color.BLACK);
        a.setFill(Color.TRANSPARENT);
        pane.getChildren().addAll(a, c);
        
        PathTransition pt = new PathTransition(Duration.millis(3000), a, c);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Animation palindrome");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
