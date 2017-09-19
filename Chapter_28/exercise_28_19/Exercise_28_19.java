package exercise_28_19;

import exercise_28_05.Graph;
import exercise_28_05.UnweightedGraph;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_28_19 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        City[] vertices = {new City("Seattle", 75, 50), new City("San Francisco", 50, 210),
            new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
            new City("Kansas City", 400, 245), new City("Chicago", 450, 100),
            new City("Boston", 700, 80), new City("New York", 675, 120),
            new City("Atlanta", 575, 295), new City("Miami", 600, 400),
            new City("Dallas", 408, 325), new City("Houston", 450, 360) };

        int[][] edges = {
            {0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2}, {1, 3},
            {2, 1}, {2, 3}, {2, 4}, {2, 10},
            {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
            {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
            {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
            {6, 5}, {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8},
            {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
            {9, 8}, {9, 11}, {10, 2}, {10, 4}, {10, 8}, {10, 11},
            {11, 8}, {11, 9}, {11, 10}
        };

        Graph<City> graph = new UnweightedGraph<>(vertices, edges);
        BorderPane borderPane = new BorderPane();
        GraphView graphView = new GraphView(graph);
        graphView.drawGraph();
        borderPane.setCenter(graphView);
        
        Button btDFS = new Button("Display DFS Tree");
        Button btBFS = new Button("Display BFS Tree");
        TextField tfCity = new TextField();
        tfCity.setAlignment(Pos.BASELINE_LEFT);
        
        HBox hBoxForButtons = new HBox(5);
        hBoxForButtons.getChildren().addAll(new Label("Starting City:"), tfCity, btDFS, btBFS);
        hBoxForButtons.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBoxForButtons);
        
        Label lbStatus = new Label();
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 750, 500);
        scene.getStylesheets().add("file:///c:/programming/java/Intro_to_Java_Programming_10th_exercises/JavaProgrammingExercises/Chapter_28/exercise_28_11/style.css");
        primaryStage.setTitle("Exercise_28_19");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btDFS.setOnAction(e -> {
            graphView.drawGraph();
            String cityname = tfCity.getText();
            boolean isContains = false;
            int i = 0;
            for(City city : vertices) {
                if(city.getName().equals(cityname)) {
                    isContains = true;
                    break;
                }
                i++;
            }
            if(isContains) {
                lbStatus.setText("The DFS traversal of the graph from " + cityname);
                graphView.setTree(graph.dfs(i));
                graphView.drawGraph();
            }
            else {
                lbStatus.setText("The map doesn't contains this city.");
            }
        });
        
        btBFS.setOnAction(e -> {
            graphView.drawGraph();
            String cityname = tfCity.getText();
            boolean isContains = false;
            int i = 0;
            for(City city : vertices) {
                if(city.getName().equals(cityname)) {
                    isContains = true;
                    break;
                }
                i++;
            }
            if(isContains) {
                lbStatus.setText("The BFS traversal of the graph from " + cityname);
                graphView.setTree(graph.bfs(i));
                graphView.drawGraph();
            }
            else {
                lbStatus.setText("The map doesn't contains this city.");
            }
        });
    }
  
    static class City implements Displayable {
        private int x, y;
        private String name;

        City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override 
        public int getX() {
            return x;
        }

        @Override 
        public int getY() {
            return y;
        }

        @Override 
        public String getName() {
            return name;
        }
    }
  
    public static void main(String[] args) {
        launch(args);
    }
}
