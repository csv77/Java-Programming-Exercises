package movecircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle(100, 100, 20);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);
        
        pane.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case LEFT : 
                    circle.setCenterX(circle.getCenterX() > circle.getRadius() ?
                        circle.getCenterX() - 20 : circle.getCenterX());
                    circle.setCenterY(circle.getCenterY());
                    break;
                case RIGHT : 
                    circle.setCenterX(circle.getCenterX() < pane.getWidth() - circle.getRadius() ?
                        circle.getCenterX() + 20 : circle.getCenterX());
                    circle.setCenterY(circle.getCenterY());
                    break;
                case UP : 
                    circle.setCenterY(circle.getCenterY() > circle.getRadius() ?
                        circle.getCenterY() - 20 : circle.getCenterY());
                    circle.setCenterX(circle.getCenterX());
                    break;
                case DOWN :
                    circle.setCenterY(circle.getCenterY() < pane.getHeight() - circle.getRadius() ?
                            circle.getCenterY() + 20 : circle.getCenterY());
                    circle.setCenterX(circle.getCenterX());
            }
        });
        
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Move Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
