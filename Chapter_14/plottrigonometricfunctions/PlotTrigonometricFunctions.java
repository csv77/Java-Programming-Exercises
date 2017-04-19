package plottrigonometricfunctions;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlotTrigonometricFunctions extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        Polyline p1 = new Polyline();
        ObservableList<Double> list1 = p1.getPoints();
        double scaleFactor = 50;
        for(int x = -170; x <= 170; x++) {
            list1.add(x + 200.0);
            list1.add(100 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
        }
        
        Polyline p2 = new Polyline();
        ObservableList<Double> list2 = p2.getPoints();
        for(int x = -170; x <= 170; x++) {
            list2.add(x + 200.0);
            list2.add(100 - scaleFactor * Math.cos((x / 100.0) * 2 * Math.PI));
        }
        
        Line lineX = new Line(20, 100, 380, 100);
        Line lineY = new Line(200, 10, 200, 200);
        
        Polyline p3 = new Polyline();
        ObservableList<Double> list3 = p3.getPoints();
        list3.addAll(lineX.getEndX() - 10, lineX.getEndY() - 5, lineX.getEndX(), lineX.getEndY(), lineX.getEndX() - 10, lineX.getEndY() + 5);
        
        Polyline p4 = new Polyline();
        ObservableList<Double> list4 = p4.getPoints();
        list4.addAll(lineY.getStartX() - 5, lineY.getStartY() + 10, lineY.getStartX(), lineY.getStartY(), lineY.getStartX() + 5, lineY.getStartY() + 10);
        
        Text t1 = new Text(lineX.getEndX() - 10, lineX.getEndY() - 10, "X");
        Text t2 = new Text(lineY.getStartX() + 10, lineY.getStartY() + 10, "Y");
        Text t3 = new Text(lineX.getStartX() + 50, lineX.getStartY() + 15, "-2\u03c0");
        Text t4 = new Text(lineX.getStartX() + 95, lineX.getStartY() + 15, "-\u03c0");
        Text t5 = new Text(lineX.getStartX() + 180, lineX.getStartY() + 15, "0");
        Text t6 = new Text(lineX.getStartX() + 255, lineX.getStartY() + 15, "\u03c0");
        Text t7 = new Text(lineX.getStartX() + 310, lineX.getStartY() + 15, "2\u03c0");
        
        pane.getChildren().addAll(p1, p2, lineX, lineY, p3, p4, t1, t2, t3, t4, t5, t6, t7);
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Plot Sin and Cos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
