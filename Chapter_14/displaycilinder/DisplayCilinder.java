package displaycilinder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DisplayCilinder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        Ellipse e = new Ellipse(80, 40, 50, 20);
        e.setStroke(Color.BLACK);
        e.setFill(Color.WHITE);
        
        Arc a1 = new Arc(e.getCenterX(), e.getCenterY() + 100, e.getRadiusX(), e.getRadiusY(), 180, 180);
        a1.setType(ArcType.OPEN);
        a1.setStroke(Color.BLACK);
        a1.setFill(Color.WHITE);
        
        Arc a2 = new Arc(a1.getCenterX(), a1.getCenterY(), a1.getRadiusX(), a1.getRadiusY(), 0, 180);
        a2.setType(ArcType.OPEN);
        a2.setStroke(Color.BLACK);
        a2.setFill(Color.WHITE);
        a2.getStrokeDashArray().addAll(6.0, 15.0);
        
        Line line1 = new Line(e.getCenterX() - e.getRadiusX(), e.getCenterY(), a1.getCenterX() - a1.getRadiusX(), a1.getCenterY());
        Line line2 = new Line(e.getCenterX() + e.getRadiusX(), e.getCenterY(), a1.getCenterX() + a1.getRadiusX(), a1.getCenterY());
                
        pane.getChildren().addAll(e, a1, a2, line1, line2);
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Cilinder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
