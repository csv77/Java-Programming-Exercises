package exercise_29_12;

import exercise_28_05.Graph;
import exercise_28_19.Displayable;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView extends Pane {
    private Graph<? extends Displayable> graph;
  
    public GraphView(Graph<? extends Displayable> graph) {
        this.graph = graph;

        List<? extends Displayable> vertices = graph.getVertices();    
        for(int i = 0; i < graph.getSize(); i++) {
            int x = vertices.get(i).getX();
            int y = vertices.get(i).getY();
            String name = vertices.get(i).getName();

            getChildren().add(new Circle(x, y, 8));
            getChildren().add(new Text(x - 8, y - 18, name)); 
        }

        for(int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            int x1 = graph.getVertex(i).getX();
            int y1 = graph.getVertex(i).getY();
            for(int v: neighbors) {
                int x2 = graph.getVertex(v).getX();
                int y2 = graph.getVertex(v).getY();

                getChildren().add(new Line(x1, y1, x2, y2)); 
            }
        }
    }
}
