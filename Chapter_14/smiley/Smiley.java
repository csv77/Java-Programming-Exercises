package smiley;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Smiley extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        StackPane stackPane2 = new StackPane();
        stackPane2.setPadding((new Insets(10, 10, 10, 10)));
        Circle c = getCircle();
        Polygon p = getPolygon(c);
        stackPane.getChildren().addAll(c, p);
        
        Pane pane = new Pane();
        Ellipse e1 = getEllipse(c);
        e1.setCenterX(c.getRadius() - c.getRadius() / 2);
        Ellipse e2 = getEllipse(c);
        e2.setCenterX(c.getRadius() + c.getRadius() / 2);
        Circle c1 = getCircle(e1);
        Circle c2 = getCircle(e2);
        Arc a = getArc(c);
        
        pane.getChildren().addAll(stackPane, e1, e2, c1, c2, a);
        stackPane2.getChildren().add(pane);
        
        Scene scene = new Scene(stackPane2);
        
        primaryStage.setTitle("Smiley");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Arc getArc(Circle c) {
        Arc a = new Arc(c.getRadius(), c.getRadius() + c.getRadius() / 3, c.getRadius() / 2, c.getRadius() / 4, 180, 180);
        a.setStroke(Color.BLACK);
        a.setFill(null);
        a.setType(ArcType.OPEN);
        return a;
    }
    
    public static Circle getCircle(Ellipse e) {
        Circle c = new Circle();
        c.setCenterX(e.getCenterX());
        c.setCenterY(e.getCenterY());
        c.setStroke(Color.BLACK);
        c.setRadius(e.getRadiusX() / 2);
        return c;
    }
    
    public static Ellipse getEllipse(Circle c) {
        Ellipse e = new Ellipse();
        e.setCenterY(c.getRadius() - c.getRadius() / 3);
        e.setRadiusX(c.getRadius() / 4);
        e.setRadiusY(c.getRadius() / 6);
        e.setStroke(Color.BLACK);
        e.setFill(Color.WHITE);
        return e;
    }
    
    public static Polygon getPolygon(Circle c) {
        double length = c.getRadius() / 4;
        Polygon p = new Polygon(c.getCenterX(), c.getCenterY() - length, c.getCenterX() - length, c.getCenterY() + length / 1.5,
                                c.getCenterX() + length, c.getCenterY() + length / 1.5);
        p.setStroke(Color.BLACK);
        p.setFill(Color.WHITE);
        return p;
    }
    
    public static Circle getCircle() {
        Circle c = new Circle(100);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        return c;
    }
    
}
