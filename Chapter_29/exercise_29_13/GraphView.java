package exercise_29_13;

import exercise_28_19.Displayable;
import exercise_29_06.WeightedGraph;
import exercise_29_13.Exercise_29_13.City;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView extends Pane {
    private WeightedGraph<? extends Displayable> graph;
    private WeightedGraph.ShortestPathTree tree;
    
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
    }
    
    public void drawPath(int startingVertex, int endingVertex) {
        tree = graph.getShortestPath(startingVertex);
        if(tree != null) {
            List<City> path = tree.getPath(endingVertex);
            for(int i = 0; i < path.size() - 1; i++) {
                int x1 = path.get(i).getX();
                int y1 = path.get(i).getY();
                int x2 = path.get(i + 1).getX();
                int y2 = path.get(i + 1).getY();
                Line line = new Line(x1, y1, x2, y2);
                line.setId("line");
                getChildren().add(line);
            }
        }
    }
}

