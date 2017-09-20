package exercise_28_23;

import exercise_28_01.AbstractGraph;
import exercise_28_01.Graph;
import exercise_28_01.UnweightedGraph;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_28_23 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new RectanglePane(), 450, 350);
        primaryStage.setTitle("Exercise_28_23");
        primaryStage.setScene(scene);
        primaryStage.show();
      }

    class RectanglePane extends Pane {
        public RectanglePane() {
            this.setOnMouseClicked(e -> {
                if(!isInsideACircle(new Point2D(e.getX(), e.getY()))) { 
                    Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 20, 20);
                    getChildren().add(rectangle);
                    colorConnectedComponents();
                }
            });
        }

        private boolean isInsideACircle(Point2D p) {
            for(Node rectangle: this.getChildren())
                if(rectangle.contains(p))
                    return true;

            return false;
        }

        private void colorConnectedComponents() {
            if(getChildren().size() == 0)
                return;

            List<AbstractGraph.Edge> edges = new ArrayList<>();
            for(int i = 0; i < getChildren().size(); i++)
                for(int j = i + 1; j < getChildren().size(); j++)
                    if(overlaps((Rectangle)(getChildren().get(i)), (Rectangle)(getChildren().get(j)))) {
                        edges.add(new AbstractGraph.Edge(i, j));
                        edges.add(new AbstractGraph.Edge(j, i));
                    }
            
            Graph<Node> graph = new UnweightedGraph<>((List<Node>)getChildren(), edges);
            AbstractGraph<Node>.Tree tree = graph.dfs(0);
            boolean isAllRectanglesConnected = getChildren().size() == tree.getNumberOfVerticesFound();

            for(Node rectangle: getChildren()) {
                if(isAllRectanglesConnected) {
                    ((Rectangle)rectangle).setFill(Color.RED);
                    ((Rectangle)rectangle).setStroke(Color.RED);
                } 
                else {
                    ((Rectangle)rectangle).setStroke(Color.BLACK);
                    ((Rectangle)rectangle).setFill(Color.WHITE);
                }
            }
        }
    }
    
    public static boolean overlaps(Rectangle rectangle1, Rectangle rectangle2) {
        Point2D p1 = new Point2D(rectangle1.getX(), rectangle1.getY());
        Point2D p2 = new Point2D(rectangle2.getX(), rectangle2.getY());
        Point2D p3 = new Point2D(rectangle1.getX() + rectangle1.getWidth(), rectangle1.getY());
        Point2D p4 = new Point2D(rectangle2.getX() + rectangle2.getWidth(), rectangle2.getY());
        return rectangle1.contains(p2) || rectangle1.contains(p4) || rectangle2.contains(p1) || rectangle2.contains(p3);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
