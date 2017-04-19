package displayanglesoftriangle;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayAnglesOfTriangle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle c1 = new Circle(100, 40, 10);
        Circle c2 = new Circle(50, 120, 10);
        Circle c3 = new Circle(200, 100, 10);
        ArrayList<Circle> points = new ArrayList<>();
        points.add(c1);
        points.add(c2);
        points.add(c3);
        drawTriangle(pane, points);
        pane.getChildren().addAll(points);
        setText(pane, points);
        
        pane.setOnMouseDragged(e -> {
            for(Circle c : points) {
                if(c.contains(e.getX(), e.getY())) {
                    pane.getChildren().clear();
                    c.setCenterX(e.getX());
                    c.setCenterY(e.getY());
                    pane.getChildren().addAll(points);
                    drawTriangle(pane, points);
                    setText(pane, points);
                }
            }
        });
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Display angles of triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public ArrayList<Double> getSides(ArrayList<Circle> points) {
        ArrayList<Double> sides = new ArrayList<>();
        double a = Math.sqrt(Math.pow(points.get(1).getCenterX() - points.get(2).getCenterX(), 2) + 
                             Math.pow(points.get(1).getCenterY() - points.get(2).getCenterY(), 2));
        double b = Math.sqrt(Math.pow(points.get(0).getCenterX() - points.get(2).getCenterX(), 2) + 
                             Math.pow(points.get(0).getCenterY() - points.get(2).getCenterY(), 2));
        double c = Math.sqrt(Math.pow(points.get(0).getCenterX() - points.get(1).getCenterX(), 2) + 
                             Math.pow(points.get(0).getCenterY() - points.get(1).getCenterY(), 2));
        sides.add(a);
        sides.add(b);
        sides.add(c);
        return sides;
    }
    
    public ArrayList<Double> getAngles(ArrayList<Circle> points) {
        ArrayList<Double> angles = new ArrayList<>();
        ArrayList<Double> sides = getSides(points);
        double alfa = Math.toDegrees(Math.acos((Math.pow(sides.get(0), 2) - Math.pow(sides.get(1), 2) -
                                     Math.pow(sides.get(2), 2)) / (-2 * sides.get(1) * sides.get(2))));
        double beta = Math.toDegrees(Math.acos((Math.pow(sides.get(1), 2) - Math.pow(sides.get(0), 2) -
                                     Math.pow(sides.get(2), 2)) / (-2 * sides.get(0) * sides.get(2))));
        double gamma = Math.toDegrees(Math.acos((Math.pow(sides.get(2), 2) - Math.pow(sides.get(1), 2) -
                                     Math.pow(sides.get(0), 2)) / (-2 * sides.get(1) * sides.get(0))));
        angles.add(alfa);
        angles.add(beta);
        angles.add(gamma);
        return angles;
    }
    
    public void setText(Pane pane, ArrayList<Circle> points) {
        ArrayList<Double> angles = getAngles(points);
        Text t1 = new Text(points.get(0).getCenterX(), points.get(0).getCenterY() - points.get(0).getRadius(),
                           String.format("%.2f", angles.get(0)));
        Text t2 = new Text(points.get(1).getCenterX(), points.get(1).getCenterY() - points.get(1).getRadius(),
                           String.format("%.2f", angles.get(1)));
        Text t3 = new Text(points.get(2).getCenterX(), points.get(2).getCenterY() - points.get(2).getRadius(),
                           String.format("%.2f", angles.get(2)));
        pane.getChildren().addAll(t1, t2, t3);
    }
    
    public void drawTriangle(Pane pane, ArrayList<Circle> points) {
        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        for(Circle c : points) {
            list.addAll(c.getCenterX(), c.getCenterY());
        }
        polygon.setStroke(Color.BLACK);
        polygon.setFill(null);
        pane.getChildren().add(polygon);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
