package connectcircles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectCircles extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        double radius = 15;
        
        Circle c1 = new Circle(Math.random() * 170 + 15, Math.random() * 170 + 15, radius);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);
        Circle c2 = new Circle(Math.random() * 170 + 15, Math.random() * 170 + 15, radius);
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.WHITE);
        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        Text t1 = new Text(c1.getCenterX(), c1.getCenterY(), "1");
        Text t2 = new Text(c2.getCenterX(), c2.getCenterY(), "2");
        
        pane.getChildren().addAll(line, c1, c2, t1, t2);
        Scene scene = new Scene(pane, 250, 250);
        
        primaryStage.setTitle("Connect Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
