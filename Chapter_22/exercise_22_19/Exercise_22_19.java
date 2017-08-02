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
    private TextField[][] tfMatrix = new TextField[N][N];
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = fillMatrix();
        
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
                }
            }
        });
        
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Exercise_22_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public GridPane fillMatrix() {
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
}
