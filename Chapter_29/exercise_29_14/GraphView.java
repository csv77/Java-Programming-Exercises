package exercise_29_14;

import exercise_28_19.Displayable;
import exercise_29_06.WeightedGraph;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView extends Pane {
    private WeightedGraph<? extends Displayable> graph;
    private WeightedGraph.MST tree;
    
    public GraphView(WeightedGraph<? extends Displayable> graph) {
        this.graph = graph;
    }
    
    public void drawGraph() {
        getChildren().clear();
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
                try { 
                    getChildren().add(new Text((x1 + x2) / 2, (y1 + y2) / 2 - 5, graph.getWeight(i, v) + ""));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        tree = graph.getMinimumSpanningTree();
        if(tree != null) {
            
            for(int i = 0; i < tree.getNumberOfVerticesFound(); i++) {
                if(tree.getParent(i) != -1) {
                    int x1 = graph.getVertex(tree.getParent(i)).getX();
                    int y1 = graph.getVertex(tree.getParent(i)).getY();
                    int x2 = graph.getVertex(i).getX();
                    int y2 = graph.getVertex(i).getY();
                    drawArrow(x1, y1, x2, y2);
                }
            }
        }
    }
    
    private void drawArrow(double x1, double y1, double x2, double y2) {
        double alfa = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
        double length = 20;
        Line line = new Line(x1, y1, x2, y2);
        line.setId("redline");
        Line line1 = new Line(x2, y2, x2 + length * Math.cos(Math.toRadians(alfa - 180 + 30)), y2 - length * Math.sin(Math.toRadians(alfa - 180 + 30)));
        line1.setId("redline");
        Line line2 = new Line(x2, y2, x2 + length * Math.cos(Math.toRadians(alfa - 180 - 30)), y2 - length * Math.sin(Math.toRadians(alfa - 180 - 30)));
        line2.setId("redline");
        getChildren().addAll(line, line1, line2);
    }
}

