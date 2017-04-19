package displaystopsign;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayStopSign extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Polygon octagon = new Polygon();
        pane.getChildren().add(octagon);
        octagon.setFill(Color.RED);
        octagon.setRotate(22.5);
        ObservableList<Double> list = octagon.getPoints();
        
        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2;
        double centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        
        for(int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(i * Math.PI / 4));
            list.add(centerY - radius * Math.sin(i * Math.PI / 4));
        }
        
        Text t = new Text("STOP");
        t.setFill(Color.WHITE);
        t.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        pane.getChildren().add(t);
        
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        
        primaryStage.setTitle("Stop sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
