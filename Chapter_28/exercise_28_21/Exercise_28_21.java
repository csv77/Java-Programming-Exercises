package exercise_28_21;

import exercise_28_04.MyGraph;
import exercise_28_01.AbstractGraph;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_28_21 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new CirclePane(), 450, 350);
        primaryStage.setTitle("Exercise_28_21");
        primaryStage.setScene(scene);
        primaryStage.show();
      }

    class CirclePane extends Pane {
        public CirclePane() {
            this.setOnMouseClicked(e -> {
                if(!isInsideACircle(new Point2D(e.getX(), e.getY()))) { 
                    getChildren().add(new Circle(e.getX(), e.getY(), 20));
                    colorConnectedComponents();
                }
            });
        }

        private boolean isInsideACircle(Point2D p) {
            for(Node circle: this.getChildren())
                if(circle.contains(p))
                    return true;

            return false;
        }

        private void colorConnectedComponents() {
            if(getChildren().size() == 0)
                return;

            List<AbstractGraph.Edge> edges = new ArrayList<>();
            for(int i = 0; i < getChildren().size(); i++)
                for(int j = i + 1; j < getChildren().size(); j++)
                    if(overlaps((Circle)(getChildren().get(i)), (Circle)(getChildren().get(j)))) {
                        edges.add(new AbstractGraph.Edge(i, j));
                        edges.add(new AbstractGraph.Edge(j, i));
                    }
            
            MyGraph<Node> graph = new MyGraph<>((List<Node>)getChildren(), edges);
            List<List<Integer>> nodeLists = graph.getConnectedComponents();
            
            List<Color> colors = new ArrayList<>();
            
            for(List<Integer> nodeList : nodeLists) {
                Color color = new Color(Math.random(), Math.random(), Math.random(), 1.0);
                colors.add(color);
                while(colors.contains(color)) {
                    color = new Color(Math.random(), Math.random(), Math.random(), 1.0);
                }
                for(Integer node : nodeList) {
                    int index = getChildren().indexOf(graph.getVertex(node));
                    Circle circle = (Circle)(getChildren().get(index));
                    circle.setFill(color);
                    circle.setStroke(color);
                }
            }
        }
    }

    public static boolean overlaps(Circle circle1, Circle circle2) {
        return new Point2D(circle1.getCenterX(), circle1.getCenterY()).distance(circle2.getCenterX(),
                circle2.getCenterY()) <= circle1.getRadius() + circle2.getRadius();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
