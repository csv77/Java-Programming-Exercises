package exercise_18_20;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_18_20 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CirclesPane pane = new CirclesPane();
        BorderPane borderPane = new BorderPane(pane);
        
        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.paint();
        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }
    
    static class CirclesPane extends Pane {

        public CirclesPane() {
        }

        protected void paint() {
            getChildren().clear();
            Point2D center = new Point2D(getWidth() / 2, getHeight() / 2);
            double radius = 10;
            displayCircles(center, radius);
        }
        
        private void displayCircles(Point2D center, double radius) {
            if(radius < getWidth() / 2 - 10 && radius < getHeight() / 2 - 10) {
                Circle c1 = new Circle(center.getX(), center.getY(), radius);
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(Color.BLACK);
                getChildren().add(c1);
                radius += 10;
                displayCircles(center, radius);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
