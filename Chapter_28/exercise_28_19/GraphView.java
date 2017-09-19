package exercise_28_19;

import exercise_28_05.AbstractGraph;
import exercise_28_05.Graph;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView extends Pane {
    private Graph<? extends Displayable> graph;
    private AbstractGraph.Tree tree;
    
    public GraphView(Graph<? extends Displayable> graph) {
        this.graph = graph;
    }
    
    public void drawGraph() {
        List<? extends Displayable> vertices = graph.getVertices();    
        for(int i = 0; i < graph.getSize(); i++) {
            int x = vertices.get(i).getX();
            int y = vertices.get(i).getY();
            String name = vertices.get(i).getName();

            getChildren().add(new Circle(x, y, 16));
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
        
        if(tree != null) {
            List<Integer> order = tree.getSearchOrder();
            for(int i = 0; i < order.size() - 1; i++) {
                int x1 = graph.getVertex(tree.getParent(order.get(i + 1))).getX();
                int y1 = graph.getVertex(tree.getParent(order.get(i + 1))).getY();
                int x2 = graph.getVertex(order.get(i + 1)).getX();
                int y2 = graph.getVertex(order.get(i + 1)).getY();
                Line line = new Line(x1, y1, x2, y2);
                line.setId("line");
                getChildren().add(line);
                drawArrow(x1, y1, x2, y2);
            }
        }
    }
    
    private void drawArrow(double x1, double y1, double x2, double y2) {
        double alfa = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
        double length = 20;
        Line line1 = new Line(x2, y2, x2 + length * Math.cos(Math.toRadians(alfa - 180 + 30)), y2 - length * Math.sin(Math.toRadians(alfa - 180 + 30)));
        line1.setId("line");
        Line line2 = new Line(x2, y2, x2 + length * Math.cos(Math.toRadians(alfa - 180 - 30)), y2 - length * Math.sin(Math.toRadians(alfa - 180 - 30)));
        line2.setId("line");
        getChildren().addAll(line1, line2);
    }

    public void setTree(AbstractGraph.Tree tree) {
        this.tree = tree;
    }
    
}
