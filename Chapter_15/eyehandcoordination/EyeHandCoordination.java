package eyehandcoordination;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EyeHandCoordination extends Application {
    static int count = 0;
    StopWatch stopWatch = new StopWatch();
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        final double width = 300;
        final double height = 200;
        Circle c1 = new Circle(10);
        setCircle(c1, width, height);
        pane.getChildren().add(c1);
        stopWatch.reset();
        
        c1.setOnMouseClicked(e -> {
            if(!stopWatch.isStopWatchRunning()) {
                stopWatch.start();
            }
            if(count < 19) {    
                pane.getChildren().clear();
                setCircle(c1, width, height);
                pane.getChildren().add(c1);
                count++;
            }
            else {
                stopWatch.stop();
                pane.getChildren().clear();
                pane.getChildren().add(new Text(30, 30, "Time spent is " + (stopWatch.getElapsedTime()) + " milliseconds"));
            }
        });
        
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Eye-hand coordination");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setCircle(Circle c, double w, double h) {
        c.setCenterX(Math.random() * (w - 2 * c.getRadius()) + c.getRadius());
        c.setCenterY(Math.random() * (h - 2 * c.getRadius()) + c.getRadius());
        c.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
