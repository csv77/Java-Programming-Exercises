package exercise_29_14;

import exercise_28_19.Displayable;
import exercise_29_06.WeightedGraph;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise_29_14 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        City[] vertices = {new City("Seattle", 75, 50), new City("San Francisco", 50, 210),
            new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
            new City("Kansas City", 400, 245), new City("Chicago", 450, 100),
            new City("Boston", 700, 80), new City("New York", 675, 120),
            new City("Atlanta", 575, 295), new City("Miami", 600, 400),
            new City("Dallas", 408, 325), new City("Houston", 450, 360) };

        int[][] edges = {
            {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
            {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
            {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
            {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599}, {3, 5, 1003},
            {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260}, {4, 8, 864}, {4, 10, 496},
            {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, {5, 6, 983}, {5, 7, 787},
            {6, 5, 983}, {6, 7, 214},
            {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
            {8, 4, 864}, {8, 7, 888}, {8, 9, 661}, {8, 10, 781}, {8, 11, 810},
            {9, 8, 661}, {9, 11, 1187},
            {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
            {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
        };

        WeightedGraph<City> graph = new WeightedGraph<>(vertices, edges);
        BorderPane borderPane = new BorderPane();
        GraphView graphView = new GraphView(graph);
        borderPane.setCenter(graphView);
        graphView.drawGraph();
        
        Scene scene = new Scene(borderPane, 750, 500);
        scene.getStylesheets().add("file:///c:/programming/java/Intro_to_Java_Programming_10th_exercises/JavaProgrammingExercises/Chapter_28/exercise_28_11/style.css");
        primaryStage.setTitle("Exercise_29_14");
        primaryStage.setScene(scene);
        primaryStage.show();
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

