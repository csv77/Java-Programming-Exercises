package exercise_29_12;

import exercise_28_19.Displayable;
import exercise_29_06.WeightedGraph;
import java.util.List;
import javafx.scene.text.Text;

public class WeightedGraphView extends GraphView {
    private WeightedGraph<? extends Displayable> graph;
    
    public WeightedGraphView(WeightedGraph<? extends Displayable> graph) {
        super(graph);

        for(int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            
            int x1 = graph.getVertex(i).getX();
            int y1 = graph.getVertex(i).getY();
            for(int v: neighbors) {
                int x2 = graph.getVertex(v).getX();
                int y2 = graph.getVertex(v).getY();

                try { 
                    getChildren().add(new Text((x1 + x2) / 2, (y1 + y2) / 2 - 5, graph.getWeight(i, v) + ""));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }   
    }
}
