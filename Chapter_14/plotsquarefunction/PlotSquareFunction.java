package plotsquarefunction;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlotSquareFunction extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane1 = new Pane();
        pane1.setRotate(180);
        pane1.setPadding(new Insets(72, 0, 0, 75));
        Pane pane2 = new Pane();
        pane2.setPadding(new Insets(5, 5, 5, 5));
        
        Polyline p1 = new Polyline();
        pane1.getChildren().add(p1);
        ObservableList<Double> list1 = p1.getPoints();
        double scaleFactor = 0.0125;
        for(int x = - 100; x <= 100; x++) {
            list1.add(x + 200.0);
            list1.add(scaleFactor * x * x);
        }
        
        Line lineX = new Line(10, 200, 350, 200);
        Line lineY = new Line(lineX.getEndX() / 2, 30, lineX.getEndX() / 2, 250);
        
        Polyline p2 = new Polyline();
        ObservableList<Double> list2 = p2.getPoints();
        list2.addAll(lineX.getEndX() - 10, lineX.getEndY() - 5, lineX.getEndX(), lineX.getEndY(), lineX.getEndX() - 10, lineX.getEndY() + 5);
        
        Polyline p3 = new Polyline();
        ObservableList<Double> list3 = p3.getPoints();
        list3.addAll(lineY.getStartX() - 5, lineY.getStartY() + 10, lineY.getStartX(), lineY.getStartY(), lineY.getStartX() + 5, lineY.getStartY() + 10);
        
        Text t1 = new Text(lineX.getEndX() - 10, lineX.getEndY() - 10, "X");
        t1.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        Text t2 = new Text(lineY.getStartX() + 10, lineY.getStartY() + 10, "Y");
        t2.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        
        pane2.getChildren().addAll(pane1, lineX, lineY, p2, p3, t1, t2);
        Scene scene = new Scene(pane2);
        primaryStage.setTitle("Plot Square Function");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
