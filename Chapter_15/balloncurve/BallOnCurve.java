package balloncurve;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BallOnCurve extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        //
        Polyline p1 = new Polyline();
        ObservableList<Double> list1 = p1.getPoints();
        double scaleFactor = 50;
        for(int x = -170; x <= 170; x++) {
            list1.add(x + 200.0);
            list1.add(100 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
        }
        
        Line lineX = new Line(20, 100, 380, 100);
        Line lineY = new Line(200, 10, 200, 200);
        
        Polyline p2 = new Polyline();
        ObservableList<Double> list2 = p2.getPoints();
        list2.addAll(lineX.getEndX() - 10, lineX.getEndY() - 5, lineX.getEndX(), lineX.getEndY(), lineX.getEndX() - 10, lineX.getEndY() + 5);
        
        Polyline p3 = new Polyline();
        ObservableList<Double> list3 = p3.getPoints();
        list3.addAll(lineY.getStartX() - 5, lineY.getStartY() + 10, lineY.getStartX(), lineY.getStartY(), lineY.getStartX() + 5, lineY.getStartY() + 10);
        
        Text t1 = new Text(lineX.getEndX() - 10, lineX.getEndY() - 10, "X");
        Text t2 = new Text(lineY.getStartX() + 10, lineY.getStartY() + 10, "Y");
        Text t3 = new Text(lineX.getStartX() + 50, lineX.getStartY() + 15, "-2\u03c0");
        Text t4 = new Text(lineX.getStartX() + 95, lineX.getStartY() + 15, "-\u03c0");
        Text t5 = new Text(lineX.getStartX() + 180, lineX.getStartY() + 15, "0");
        Text t6 = new Text(lineX.getStartX() + 255, lineX.getStartY() + 15, "\u03c0");
        Text t7 = new Text(lineX.getStartX() + 310, lineX.getStartY() + 15, "2\u03c0");
        
        Circle c = new Circle(10);
        c.setFill(Color.ORANGE);
        
        pane.getChildren().addAll(p1, lineX, lineY, p2, p3, t1, t2, t3, t4, t5, t6, t7, c);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Ball on curve");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        PathTransition pt = new PathTransition(Duration.millis(6000), p1, c);
        pt.setCycleCount(Timeline.INDEFINITE);
        //pt.setAutoReverse(false);
        pt.play();
        
        pane.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.SECONDARY)) {
                pt.pause();
            }
            else if(e.getButton().equals(MouseButton.PRIMARY)) {
                pt.play();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
