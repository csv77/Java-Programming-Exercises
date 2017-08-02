package exercise_22_17;
/*
Not finished yet, the algorithm doesn't works properly
*/
import exercise_22_07.Point;
import exercise_22_07.Pair;
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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise_22_17 extends Application {
    private Pane pane = new Pane();
    private ArrayList<Circle> listOfPoints = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(2);
        vBox.setPadding(new Insets(2, 2, 2, 2));
        vBox.setStyle("-fx-border-color: black");
        
        vBox.getChildren().addAll(new Label("INSTRUCTION"),
                new Label("Add: Left Click"), new Label("Remove: Right Click"));
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
                listOfPoints.add(c);
                pane.getChildren().add(c);
                drawLineOfClosestPoints(listOfPoints);
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                ObservableList<Node> listOfNodes = pane.getChildren();
                for(int i = 0; i < listOfNodes.size(); i++) {
                    Node node = listOfNodes.get(i);
                    if(node.contains(e.getX(), e.getY()) && node instanceof Circle) {
                        pane.getChildren().remove(node);
                        listOfPoints.remove((Circle)node);
                        drawLineOfClosestPoints(listOfPoints);
                    }
                }
            }
        });
        
        Scene scene = new Scene(pane, 500, 250);
        primaryStage.setTitle("Exercise_22_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void drawLineOfClosestPoints(ArrayList<Circle> circles) {
        ObservableList<Node> listOfNodes = pane.getChildren();
        for(int i = 0; i < listOfNodes.size(); i++) {
            Node node = listOfNodes.get(i);
            if(node instanceof Line) {
                pane.getChildren().remove(node);
            }
        }
        
        Point[] points = new Point[circles.size()];
        int i = 0;
        for(Circle c : circles) {
            points[i] = new Point(c.getCenterX(), c.getCenterY());
            i++;
        }
        
        if(points.length > 1) {
            Pair pair = Pair.getClosestPair(points);
            
            Line line = new Line(pair.getP1().getX(), pair.getP1().getY(),
                    pair.getP2().getX(), pair.getP2().getY());

            pane.getChildren().add(line);
        }
    }
}
