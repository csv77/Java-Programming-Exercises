package boundingrectangle;

import java.util.ArrayList;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BoundingRectangle extends Application {
    private Pane pane = new Pane();
    private ArrayList<Circle> listOfCircles = new ArrayList<>();
            
    @Override
    public void start(Stage primaryStage) {
        pane.setPadding(new Insets(10, 10, 10, 10));
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
            if(e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(e.getX(), e.getY(), 10);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                listOfCircles.add(circle);
                pane.getChildren().add(circle);
                getRectangle();
            }
            else if(e.getButton() == MouseButton.SECONDARY) {
                ObservableList<Node> listOfNode = pane.getChildren();
                for(int i = listOfNode.size() - 1; i >= 0; i--) {
                    Node c = listOfNode.get(i);
                    //Circle c = listOfCircles.get(i);
                    if(c.contains(e.getX(), e.getY()) && c instanceof Circle) {
                        listOfCircles.remove(c);
                        pane.getChildren().remove(c);
                        break;
                    }
                }
                getRectangle();
            }
        });
        
        Scene scene = new Scene(pane, 500, 250);
        primaryStage.setTitle("Bounding rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void getRectangle() {
        removeRectangle();
        Circle first = listOfCircles.get(0);
        double minX = first.getCenterX() - first.getRadius(), minY = first.getCenterY() - first.getRadius(),
                maxX = first.getCenterX() + first.getRadius(), maxY = first.getCenterY() + first.getRadius();
        for(int i = 0; i < listOfCircles.size(); i++) {
            Circle c = listOfCircles.get(i);
            if(minX > c.getCenterX() - c.getRadius()) {
                minX = c.getCenterX() - c.getRadius();
            }
            if(minY > c.getCenterY() - c.getRadius()) {
                minY = c.getCenterY() - c.getRadius();
            }
            if(maxX < c.getCenterX() + c.getRadius()) {
                maxX = c.getCenterX() + c.getRadius();
            }
            if(maxY < c.getCenterY() + c.getRadius()) {
                maxY = c.getCenterY() + c.getRadius();
            }
        }
        Rectangle rectangle = new Rectangle(minX, minY, maxX - minX, maxY - minY);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        pane.getChildren().add(rectangle);
    }
    
    public void removeRectangle() {
        ObservableList<Node> list = pane.getChildren();
        for(Node a : list) {
            if(a instanceof Rectangle) {
                pane.getChildren().remove(a);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
