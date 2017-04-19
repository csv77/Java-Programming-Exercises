package drawlines;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class DrawLines extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Polyline p = new Polyline(150, 150);
        ObservableList<Double> list = p.getPoints();
        p.setStroke(Color.BLACK);
        pane.getChildren().add(p);
        
        pane.setOnKeyPressed(e -> {
            double length = 10;
            double x = 0, y = 0;
            switch(e.getCode()) {
                case RIGHT : 
                    x = list.get(list.size() - 2) + length;
                    y = list.get(list.size() - 1);
                    break;
                case LEFT : 
                    x = list.get(list.size() - 2) - length;
                    y = list.get(list.size() - 1);
                    break;
                case UP : 
                    x = list.get(list.size() - 2);
                    y = list.get(list.size() - 1) - length;
                    break;
                case DOWN : 
                    x = list.get(list.size() - 2);
                    y = list.get(list.size() - 1) + length;
                    break;
            }
            list.add(x);
            list.add(y);
        });
        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Draw Lines");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
