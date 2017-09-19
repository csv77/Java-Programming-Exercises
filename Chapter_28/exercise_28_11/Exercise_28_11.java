package exercise_28_11;

import java.util.List;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_28_11 extends Application {
    private NineTailModel model = new NineTailModel();
    private NineTailPane pane = new NineTailPane();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        HBox hBoxForButtons = new HBox();
        
        Button btSolve = new Button("Solve");
        Button btStart = new Button("Start Over");
        hBoxForButtons.getChildren().addAll(btSolve, btStart);
        borderPane.setBottom(hBoxForButtons);
        
        HBox hBoxForNodes = new HBox();
        hBoxForNodes.getChildren().add(pane);
        hBoxForNodes.setId("hboxfornodes");
        borderPane.setCenter(hBoxForNodes);
        
        Scene scene = new Scene(borderPane, 300, 150);
        //scene.getStylesheets().add(exercise_28_11.Exercise_28_11.class.getResource("style.css").toExternalForm());
        scene.getStylesheets().add("file:///c:/egyéb/SZE/Intro_to_Java_Programming_10th_exercises/Java-Programming-Exercises/Chapter_28/exercise_28_11/style.css");
        primaryStage.setTitle("Exercise_28_11");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btSolve.setOnAction(e -> {
            hBoxForNodes.getChildren().clear();
            hBoxForNodes.getChildren().add(pane);
            pane.setInitialNode();
            List<Integer> path = model.getShortestPath(NineTailModel.getIndex(pane.node));
            for(int i = 1; i < path.size(); i++) {
                char[] node = NineTailModel.getNode(path.get(i));
                char[] previousNode = NineTailModel.getNode(path.get(i - 1));
                NineTailPane nextPane = new NineTailPane(node, previousNode);
                hBoxForNodes.getChildren().add(nextPane);
            }
            primaryStage.setWidth((path.size() + 1) * pane.getWidth());
            
        });
        
        btStart.setOnAction(e -> {
            hBoxForNodes.getChildren().clear();
            pane = new NineTailPane();
            hBoxForNodes.getChildren().add(pane);
        });
    }
    
    public class NineTailPane extends GridPane {
        private char[] node = new char[9];
        private char[] previousNode = new char[9];
        
        public NineTailPane() {
            for(int i = 0; i < 9; i++) {
                Label lbHOrT = new Label("H");
                lbHOrT.setId("labels");
                this.add(lbHOrT, i % 3, i / 3);
                lbHOrT.setOnMouseClicked(e -> {
                    if(lbHOrT.getText().equals("H")) {
                        lbHOrT.setText("T");
                    }
                    else {
                        lbHOrT.setText("H");
                    }
                });
            }
            this.setId("pane");
        }
        
        public NineTailPane(char[] node, char[] previousNode) {
            this.node = node;
            this.previousNode = previousNode;
            for(int i = 0; i < 9; i++) {
                Label lbHOrT = new Label(node[i] + "");
                if(node[i] != previousNode[i]) {
                    lbHOrT.setId("labelwithred");
                }
                else {
                    lbHOrT.setId("labels");
                }
                this.add(lbHOrT, i % 3, i / 3);
            }
            this.setId("pane");
        }
        
        public void setInitialNode() {
            ObservableList<Node> list = this.getChildren();
            for(int i = 0; i < list.size(); i++) {
                node[i] = ((Label)list.get(i)).getText().charAt(0);
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
