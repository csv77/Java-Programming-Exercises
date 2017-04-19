package insidepolygon;

import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsidePolygon extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 5, 5, 10));
        Scanner input = new Scanner(System.in);
        
        Polygon p1 = new Polygon();
        pane.getChildren().add(p1);
        p1.setStroke(Color.BLACK);
        p1.setFill(Color.WHITE);
        ObservableList<Double> list = p1.getPoints();
        System.out.print("Enter 4 coordinates of the polygon: ");
        for(int i = 0; i < 8; i++) {
            list.add(input.nextDouble());
        }
        
        System.out.print("Enter the coordinates of the point: ");
        Circle c1 = new Circle(input.nextDouble(), input.nextDouble(), 5);
        pane.getChildren().add(c1);
        
        String text = "    ";
        if(p1.contains(c1.getCenterX(), c1.getCenterY())) {
            text += "The point is inside the polygon";
        }
        else {
            text += "The point is outside the polygon";
        }
        
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(pane, new Text(text));
        Scene scene = new Scene(vBox);
        
        primaryStage.setTitle("Inside a polygon?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
