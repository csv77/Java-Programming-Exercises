package resizecylinder;

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

public class ResizeCylinder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        Ellipse e = new Ellipse(150, 100, 50, 20);
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
        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Resize cylinder");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.widthProperty().addListener(ov -> {
            line1.setStartX(pane.getWidth() / 3);
            line1.setEndX(pane.getWidth() / 3);
            line2.setStartX(pane.getWidth() / 3 * 2);
            line2.setEndX(pane.getWidth() / 3 * 2);
            e.setCenterX(pane.getWidth() / 2);
            e.setRadiusX(pane.getWidth() / 6);
            a1.setCenterX(pane.getWidth() / 2);
            a1.setRadiusX(pane.getWidth() / 6);
            a2.setCenterX(pane.getWidth() / 2);
            a2.setRadiusX(pane.getWidth() / 6);
        });
        
        pane.heightProperty().addListener(ov -> {
            line1.setStartY(pane.getHeight() / 3);
            line1.setEndY(pane.getHeight() / 3 * 2);
            line2.setStartY(pane.getHeight() / 3);
            line2.setEndY(pane.getHeight() / 3 * 2);
            e.setCenterY(pane.getHeight() / 3);
            e.setRadiusY(pane.getHeight() / 30 * 2);
            a1.setCenterY(pane.getHeight() / 3 * 2);
            a1.setRadiusY(pane.getHeight() / 30 * 2);
            a2.setCenterY(pane.getHeight() / 3 * 2);
            a2.setRadiusY(pane.getHeight() / 30 * 2);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
