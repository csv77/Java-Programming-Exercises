package dragpoints;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DragPoints extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Circle circle = new Circle(150, 125, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);
        pane.getChildren().add(circle);
        
        Circle[] points = getRandomPoints(circle);
        Text[] texts = new Text[3];
        Line[] lines = new Line[3];
        
        for(int i = 0; i < points.length; i++) {
            texts[i] = new Text();
            final int index = i;
            points[index].setOnMouseDragged(e -> {
                double radian = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
                points[index].setCenterX(circle.getCenterX() + Math.cos(radian) * circle.getRadius());
                points[index].setCenterY(circle.getCenterY() + Math.sin(radian) * circle.getRadius());
                updateLines(lines, points, texts);
            });
        }
        
        for (int i = 0; i < lines.length; i++) {
            int cIndex2 = (i + 1 >= points.length) ? 0 : i + 1;
            lines[i] = new Line(
                    points[i].getCenterX(), points[i].getCenterY(),
                    points[cIndex2].getCenterX(), points[cIndex2].getCenterY());
        }

        updateLines(lines, points, texts);
        pane.getChildren().addAll(points);
        pane.getChildren().addAll(lines);
        pane.getChildren().addAll(texts);
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Drag points");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void updateLines(Line[] lines, Circle[] p, Text[] angles) {
        for (int i = 0; i < lines.length; i++) {
            int cIndex2 = (i + 1 >= p.length) ? 0 : i + 1;
            lines[i].setStartX(p[i].getCenterX());
            lines[i].setStartY(p[i].getCenterY());
            lines[i].setEndX(p[cIndex2].getCenterX());
            lines[i].setEndY(p[cIndex2].getCenterY());
            angles[i].setX(p[i].getCenterX() + 5);
            angles[i].setY(p[i].getCenterY() - 5);
        }

        double a = Math.sqrt(Math.pow(lines[0].getStartX() - lines[0].getEndX(), 2) + Math.pow(lines[0].getStartY() - lines[0].getEndY(), 2));
        double b = Math.sqrt(Math.pow(lines[1].getStartX() - lines[1].getEndX(), 2) + Math.pow(lines[1].getStartY() - lines[1].getEndY(), 2));
        double c = Math.sqrt(Math.pow(lines[2].getStartX() - lines[2].getEndX(), 2) + Math.pow(lines[2].getStartY() - lines[2].getEndY(), 2));
        
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        angles[2].setText(String.format("%.2f", A));

        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        angles[0].setText(String.format("%.2f", B));

        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));
        angles[1].setText(String.format("%.2f", C));
    }
    
    public Circle[] getRandomPoints(Circle c) {
        double[] angles = new double[3];
        Circle[] points = new Circle[3];
        for(int i = 0; i < angles.length; i++) {
            double angle = Math.random() * 2 * Math.PI;
            angles[i] = angle;
            points[i] = new Circle(5);
            points[i].setCenterX(c.getCenterX() + Math.cos(angles[i]) * c.getRadius());
            points[i].setCenterY(c.getCenterY() - Math.sin(angles[i]) * c.getRadius());
        }
        return points;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
