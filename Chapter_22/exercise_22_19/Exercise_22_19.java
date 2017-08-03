package exercise_22_19;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_22_19 extends Application {
    private static final int N = 10;
    
    @Override
    public void start(Stage primaryStage) {
        TextField[][] tfMatrix = new TextField[N][N];
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = fillMatrix(tfMatrix);
        
        Button btRefresh = new Button("Refresh");
        Button btFindLargestBlock = new Button("Find Largest Block");
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(2));
        hBox.getChildren().addAll(btRefresh, btFindLargestBlock);
        
        borderPane.setBottom(hBox);
        borderPane.setCenter(gridPane);
        borderPane.setPadding(new Insets(2));
        
        btRefresh.setOnAction(e -> {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    tfMatrix[i][j].setText("" + (int)(Math.random() * 2));
                    tfMatrix[i][j].setStyle(null);
                }
            }
        });
        
        btFindLargestBlock.setOnAction(e -> {
            int[] blockInfo = findLargestBlock(tfMatrix);
            for(int i = blockInfo[0]; i < blockInfo[0] + blockInfo[2]; i++) {
                for(int j = blockInfo[1]; j < blockInfo[1] + blockInfo[2]; j++) {
                    tfMatrix[i][j].setStyle("-fx-background-color: lightgrey");
                }
            }
        });
        
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Exercise_22_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public int[] findLargestBlock(TextField[][] tfMatrix) {
        int[] blockInfo = new int[3];
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            matrix[0][i] = Integer.parseInt(tfMatrix[0][i].getText());
        }
        
        for(int i = 0; i < N; i++) {
            matrix[i][0] = Integer.parseInt(tfMatrix[i][0].getText());
        }
                
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                if(Integer.parseInt(tfMatrix[i][j].getText()) == 0) {
                    matrix[i][j] = 0;
                }
                else if(Integer.parseInt(tfMatrix[i][j].getText()) == 1) {
                    int min = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                    matrix[i][j] = Math.min(min, matrix[i][j - 1]) + 1;
                }
            }
        }
        
        blockInfo[2] = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                if(blockInfo[2] <= matrix[i][j]) {
                    blockInfo[2] = matrix[i][j];
                    blockInfo[0] = i - blockInfo[2] + 1;
                    blockInfo[1] = j - blockInfo[2] + 1;
                }
            }
        }
        
        return blockInfo;
    }
    
    public GridPane fillMatrix(TextField[][] tfMatrix) {
        GridPane pane = new GridPane();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                tfMatrix[i][j] = new TextField("" + (int)(Math.random() * 2));
                tfMatrix[i][j].setPrefColumnCount(1);
                tfMatrix[i][j].setAlignment(Pos.CENTER);
                pane.add(tfMatrix[i][j], j, i);
            }
        }
        return pane;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
