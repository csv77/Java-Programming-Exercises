package drawarrowline;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class DrawArrowLine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        double startX = Math.random() * 200;
        double startY = Math.random() * 200;
        double endX = Math.random() * 200;
        double endY = Math.random() * 200;
        drawArrowLine(startX, startY, endX, endY, pane);
        Scene scene = new Scene(pane, 200, 200);
        
        primaryStage.setTitle("Draw Arrow");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
        Line line = new Line(startX, startY, endX, endY);
        if(startX <= endX && startY > endY) {
            Polyline p = new Polyline(endX - 10, endY, endX, endY, endX, endY + 10);
            pane.getChildren().addAll(line, p);
        }
        else if(startX < endX && startY <= endY){
            Polyline p = new Polyline(endX - 10, endY, endX, endY, endX, endY - 10);
            pane.getChildren().addAll(line, p);
        }
        else if(startX >= endX && startY < endY) {
            Polyline p = new Polyline(endX + 10, endY, endX, endY, endX, endY - 10);
            pane.getChildren().addAll(line, p);
        }
        else {
            Polyline p = new Polyline(endX, endY + 10, endX, endY, endX + 10, endY);
            pane.getChildren().addAll(line, p);
        }
    }
}
