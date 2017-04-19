package displayfourfans;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DisplayFourFans extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                StackPane stackPane = new StackPane();
                Circle c = new Circle();
                c.setRadius(100);
                c.setStroke(Color.BLACK);
                c.setFill(Color.WHITE);
                stackPane.getChildren().add(c);
                getArcs(stackPane);
                gridPane.add(stackPane, i, j);
            }
        }
        Scene scene = new Scene(gridPane);
        
        primaryStage.setTitle("Four Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void getArcs(StackPane stackPane) {
        for(int i = 0; i < 4; i++) {
            Pane pane = new Pane(); 
            Arc a = new Arc(100, 100, 80, 80, 25 + i * 90, 40);
            a.setType(ArcType.ROUND);
            a.setFill(Color.RED);
            pane.getChildren().add(a);
            stackPane.getChildren().add(pane);
        }
        
    }
    
}
