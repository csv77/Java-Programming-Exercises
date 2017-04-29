package exercise_16_30;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise_16_30 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ConsecutiveFourPane pane = new ConsecutiveFourPane(6, 7);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_30");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public class ConsecutiveFourPane extends BorderPane {
        private Cell[][] cell;
        private Label lbStatus = new Label("Click 'Solve' to check solution!");
        private Button btSolve = new Button("Solve");
        private GridPane paneForCells = new GridPane();
        private ArrayList<Integer> indices = new ArrayList<>();

        public ConsecutiveFourPane(int numberOfRows, int numberOfColumns) {
            paneForCells.setVgap(3);
            paneForCells.setHgap(3);
            lbStatus.setAlignment(Pos.CENTER);
            setPadding(new Insets(5, 10, 5, 10));
            lbStatus.setFont(new Font(13));
            
            cell = new Cell[numberOfRows][numberOfColumns];
            for(int i = 0; i < cell.length; i++) {
                for(int j = 0; j < cell[i].length; j++) {
                    cell[i][j] = new Cell();
                    paneForCells.add(cell[i][j], j, i);
                }
            }
            
            btSolve.setOnAction(e -> solve());
            setCenter(paneForCells);
            setTop(new StackPane(lbStatus));
            setBottom(new StackPane(btSolve));
        }
        
        public void solve() {
            for(int i = 0; i < cell.length; i++) {
                for(int j = 0; j < cell[i].length; j++) {
                    cell[i][j].setNumber();
                }
            }
            
            boolean isSolved = isConsecutiveFour();
            if(isSolved) {
                lbStatus.setText("A consecutive four found!");
                lbStatus.setTextFill(Color.BLUE);
                for(int i = 0; i < indices.size(); i += 2) {
                    cell[indices.get(i)][indices.get(i + 1)].tf.setStyle("-fx-border-color: blue");
                }
            }
            else {
                lbStatus.setText("Any consecutive four found!");
                lbStatus.setTextFill(Color.RED);
            }
            
        }
        
        public boolean isConsecutiveFour() {
            
            for(int i = 0; i < cell.length; i++) {
                int current = cell[i][0].getNumber();
                for(int j = 0; j < cell[i].length; j++) {
                    if(current == cell[i][j].getNumber()) {
                        indices.add(i);
                        indices.add(j);
                        if(indices.size() == 8) {
                            return true;
                        }
                    }
                    else {
                        current = cell[i][j].getNumber();
                        indices.clear();
                        indices.add(i);
                        indices.add(j);
                    }
                }
                indices.clear();
            }
            
            for(int i = 0; i < cell[0].length; i++) {
                int current = cell[0][i].getNumber();
                for(int j = 0; j < cell.length; j++) {
                    if(current == cell[j][i].getNumber()) {
                        indices.add(j);
                        indices.add(i);
                        if(indices.size() == 8) {
                            return true;
                        }
                    }
                    else {
                        current = cell[j][i].getNumber();
                        indices.clear();
                        indices.add(j);
                        indices.add(i);
                    }
                }
                indices.clear();
            }
            
            for(int j = 0; j < cell[0].length - 3; j++) {
                int current = cell[0][j].getNumber();
                int k = j;
                for(int i = 0; i < cell.length && k < cell[i].length; i++, k++) {
                    if(current == cell[i][k].getNumber()) {
                        indices.add(i);
                        indices.add(k);
                        if(indices.size() == 8) {
                            return true;
                        }
                    }
                    else {
                        current = cell[i][k].getNumber();
                        indices.clear();
                        indices.add(i);
                        indices.add(k);
                    }
                }
                indices.clear();
            }
            
            for(int i = 0; i < cell.length - 3; i++) {
                int current = cell[i][0].getNumber();
                int k = i;
                for(int j = 0; j < cell[i].length && k < cell.length; j++, k++) {
                    if(current == cell[k][j].getNumber()) {
                        indices.add(k);
                        indices.add(j);
                        if(indices.size() == 8) {
                            return true;
                        }
                    }
                    else {
                        current = cell[k][j].getNumber();
                        indices.clear();
                        indices.add(k);
                        indices.add(j);
                    }
                }
                indices.clear();
            }
            
            for(int j = cell[0].length - 1; j > 3; j--) {
                int current = cell[0][j].getNumber();
                int k = j;
                for(int i = 0; i < cell.length && k >= 0; i++, k--) {
                    if(current == cell[i][k].getNumber()) {
                        indices.add(i);
                        indices.add(k);
                        if(indices.size() == 8) {
                            return true;
                        }
                    }
                    else {
                        current = cell[i][k].getNumber();
                        indices.clear();
                        indices.add(i);
                        indices.add(k);
                    }
                }
                indices.clear();
            }
            
            for(int i = 0; i < cell.length - 3; i++) {
                int current = cell[i][cell[i].length - 1].getNumber();
                int k = i;
                for(int j = cell[k].length - 1; j >= 0 && k < cell.length; j--, k++) {
                    if(current == cell[k][j].getNumber()) {
                        indices.add(k);
                        indices.add(j);
                        if(indices.size() == 8) {
                            return true;
                        }
                    }
                    else {
                        current = cell[k][j].getNumber();
                        indices.clear();
                        indices.add(k);
                        indices.add(j);
                    }
                }
                indices.clear();
            }
            
            return false;
        }
        
        public class Cell extends Pane {
            private int number;
            private TextField tf = new TextField();

            public Cell() {
                this.number = (int)(Math.random() * 10);
                tf.setText(String.valueOf(number));
                tf.setPrefColumnCount(2);
                tf.setAlignment(Pos.CENTER);
                getChildren().add(tf);
            }

            public int getNumber() {
                return number;
            }

            public void setNumber() {
                this.number = Integer.parseInt(tf.getText());
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
