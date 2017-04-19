package displaygrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DisplayGrid extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Line line1 = new Line();
        line1.startXProperty().bind(pane.widthProperty().divide(3));
        line1.endXProperty().bind(pane.widthProperty().divide(3));
        line1.endYProperty().bind(pane.heightProperty());
        line1.setStroke(Color.RED);
        
        Line line2 = new Line();
        line2.startXProperty().bind(pane.widthProperty().multiply(2.0 / 3));
        line2.endXProperty().bind(pane.widthProperty().multiply(2.0 / 3));
        line2.endYProperty().bind(pane.heightProperty());
        line2.setStroke(Color.RED);
                
        Line line3 = new Line();
        line3.startYProperty().bind(pane.heightProperty().divide(3));
        line3.endXProperty().bind(pane.widthProperty());
        line3.endYProperty().bind(pane.heightProperty().divide(3));
        line3.setStroke(Color.BLUE);
        
        Line line4 = new Line();
        line4.startYProperty().bind(pane.heightProperty().multiply(2.0 / 3));
        line4.endXProperty().bind(pane.widthProperty());
        line4.endYProperty().bind(pane.heightProperty().multiply(2.0 / 3));
        line4.setStroke(Color.BLUE);
        
        pane.getChildren().addAll(line1, line2, line3, line4);
        
        Scene scene = new Scene(pane, 200, 200);
        
        primaryStage.setTitle("Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
