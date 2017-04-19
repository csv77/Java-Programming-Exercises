package resizestopsign;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResizeStopSign extends Application {
    private static double WIDTH = 200;
    private static double HEIGHT = 200;
    StackPane pane = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {
        pane.setPadding(new Insets(10, 10, 10, 10));
        Polygon octagon = new Polygon();
        octagon.setFill(Color.RED);
        octagon.setRotate(22.5);
        ObservableList<Double> list = octagon.getPoints();
                
        Text t = new Text("STOP");
        t.setFill(Color.WHITE);
        t.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        pane.getChildren().addAll(octagon, t);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Resize stop sign");
        setPoints(list);
        
        pane.widthProperty().addListener(ov -> {
            setPoints(list);
            t.setFont(Font.font("Arial", FontWeight.BOLD, Math.min(pane.getWidth(), pane.getHeight()) * 0.25));
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setPoints(ObservableList<Double> list) {
        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;
        double radius = Math.min(pane.getWidth(), pane.getHeight()) * 0.4;
        list.clear();
        
        for(int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(i * Math.PI / 4));
            list.add(centerY - radius * Math.sin(i * Math.PI / 4));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
