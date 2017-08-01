package exercise_22_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Exercise_22_13 extends Application {
    private Pane pane = new Pane();
    private ArrayList<Circle> listOfCircles = new ArrayList<>();
    private Polygon polygon = new Polygon();
        
    @Override
    public void start(Stage primaryStage) {
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.TRANSPARENT);
        pane.getChildren().add(polygon);
        
        VBox vBox = new VBox(2);
        vBox.setPadding(new Insets(2, 2, 2, 2));
        vBox.setStyle("-fx-border-color: black");
        
        Label label1 = new Label("INSTRUCTION");
        Label label2 = new Label("Add: Left Click");
        Label label3 = new Label("Remove: Right Click");
        vBox.getChildren().addAll(label1, label2, label3);
        pane.getChildren().add(vBox);
        vBox.setLayoutX(10);
        vBox.setLayoutY(10);
        
        pane.setOnMouseClicked(e -> {
            if(vBox.contains(e.getX(), e.getY())) {
                return;
            }
            
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                Circle c = new Circle(e.getX(), e.getY(), 5);
                c.setFill(Color.BLACK);
                listOfCircles.add(c);
                pane.getChildren().add(c);
                drawConvexHull(listOfCircles);
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                ObservableList<Node> listOfNodes = pane.getChildren();
                for(int i = 0; i < listOfNodes.size(); i++) {
                    Node node = listOfNodes.get(i);
                    if(node.contains(e.getX(), e.getY()) && node instanceof Circle) {
                        pane.getChildren().remove(node);
                        listOfCircles.remove((Circle)node);
                        drawConvexHull(listOfCircles);
                    }
                }
            }
        });
        
        Scene scene = new Scene(pane, 500, 250);
        primaryStage.setTitle("Exercise_22_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void drawConvexHull(ArrayList<Circle> circles) {
        LinkedList<MyPoint> convexHull = new LinkedList<>();
        ArrayList<MyPoint> points = new ArrayList<>();
        
        for(Circle c : circles) {
            points.add(new MyPoint(c.getCenterX(), c.getCenterY()));
        }
        
        if(points.size() > 0) {
            MyPoint p0 = points.get(0);
            for(MyPoint point : points) {
                if(p0.y < point.y) {
                    p0 = point;
                }
                else if(p0.y == point.y && p0.x < point.x) {
                    p0 = point;
                }
            }
            convexHull.add(p0);

            for(MyPoint point : points) {
                point.setRightMostLowestPoint(p0);
            }
            Collections.sort(points);

            convexHull.add(points.get(0));
            if(points.size() > 1) {
                convexHull.add(points.get(1));
            }
        }
        
        int i = 2;
        while(i < points.size()) {
            MyPoint t1 = convexHull.removeLast();
            MyPoint t2 = convexHull.getLast();
            convexHull.add(t1);
            if(getPosition(t2, t1, points.get(i)) < 0) {
                convexHull.add(points.get(i));
                i++;
            }
            else {
                convexHull.removeLast();
            }
        }
        if(convexHull.size() > 0) {
            convexHull.removeLast();
        }
        
        polygon.getPoints().clear();
        ObservableList<Double> listOfPoints = polygon.getPoints();
        for(MyPoint p : convexHull) {
            listOfPoints.add(p.x);
            listOfPoints.add(p.y);
        }
    }
    
    public static double getPosition(MyPoint p0, MyPoint p1, MyPoint p2) {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
    }
    
    private static class MyPoint implements Comparable<MyPoint> {
        double x, y;
        MyPoint rightMostLowestPoint;

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        public void setRightMostLowestPoint(MyPoint p) {
            this.rightMostLowestPoint = p;
        }
        
        public double getAngle() {
            return Math.atan2(rightMostLowestPoint.y - this.y, rightMostLowestPoint.x - this.x);
        }
        
        public double getDistanceFromRightMostLowestPoint() {
            return Math.sqrt(Math.pow((this.x - rightMostLowestPoint.x), 2) +
                    Math.pow(this.y - rightMostLowestPoint.y, 2));
        }
        
        @Override
        public int compareTo(MyPoint o) {
            if(getAngle() < o.getAngle()) {
                return 1;
            }
            else if(getAngle() == o.getAngle() &&
                    getDistanceFromRightMostLowestPoint() > o.getDistanceFromRightMostLowestPoint()) {
                return 0;
            }
            else {
                return -1;
            }
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ") ";
        }
    }
}