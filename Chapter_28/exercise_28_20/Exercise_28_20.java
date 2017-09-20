package exercise_28_20;

import exercise_28_05.AbstractGraph;
import exercise_28_05.AbstractGraph.Edge;
import exercise_28_05.Graph;
import exercise_28_05.UnweightedGraph;
import exercise_28_19.Displayable;
import exercise_28_19.GraphView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_28_20 extends Application {
    private File file;
    private List<Vertice> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        TextField tfFile = new TextField();
        tfFile.setAlignment(Pos.BASELINE_RIGHT);
        tfFile.setPrefColumnCount(15);
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("Enter a filename with path: "), tfFile);
        borderPane.setBottom(hBox);
        
        Label lbStatus = new Label();
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        tfFile.setOnAction(e -> {
            file = new File(tfFile.getText());
        
            try(Scanner input = new Scanner(file);) {
                if(input.hasNext()) {
                    int numberOfVertices = Integer.parseInt(input.nextLine());
                }
                while(input.hasNext()) {
                    String s = input.nextLine();
                    String[] array = s.split("[\\s+]");

                    int x = Integer.parseInt(array[1]);
                    int y = Integer.parseInt(array[2]);
                    vertices.add(new Vertice(array[0], x, y));
                    for(int i = 3; i < array.length; i++) {
                        int v = Integer.parseInt(array[i]);
                        edges.add(new AbstractGraph.Edge(Integer.parseInt(array[0]), v));
                    }
                }
                lbStatus.setText("The file contains this graph.");
            }
            catch(FileNotFoundException ex) {
                lbStatus.setText("File not found.");
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("Invalid data in the file.");
            }

            Graph<Vertice> graph = new UnweightedGraph<>(vertices, edges);
            GraphView graphView = new GraphView(graph);
            graphView.drawGraph();
            borderPane.setCenter(graphView);
        });
        
        Scene scene = new Scene(borderPane, 500, 400);
        scene.getStylesheets().add("file:///c:/egyéb/SZE/Intro_to_Java_Programming_10th_exercises/Java-Programming-Exercises/Chapter_28/exercise_28_11/style.css");
        primaryStage.setTitle("Exercise_28_20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    static class Vertice implements Displayable {
        private int x, y;
        private String name;
        
        Vertice(String name, int x, int y) {
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
