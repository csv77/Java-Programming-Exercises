package displaypiechart;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayPieChart extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        String[] type = {"Project", "Quiz", "Midterm", "Final"};
        double[] grade = {20, 10, 30, 40};
        
        Text t1 = new Text(100, 80, type[0] + " -- " + grade[0] + "%");
        Text t2 = new Text(80, 15, type[1] + " -- " + grade[1] + "%");
        Text t3 = new Text(5, 100, type[2] + " -- " + grade[2] + "%");
        Text t4 = new Text(100, 180, type[3] + " -- " + grade[3] + "%");
        
        Arc arc1 = new Arc(100, 100, 80, 80, 0, grade[0] / 100 * 360);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.RED);
        
        Arc arc2 = new Arc(100, 100, 80, 80, arc1.getStartAngle() + arc1.getLength(), grade[1] / 100 * 360);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.BLUE);
        
        Arc arc3 = new Arc(100, 100, 80, 80, arc2.getStartAngle() + arc2.getLength(), grade[2] / 100 * 360);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.GREEN);
        
        Arc arc4 = new Arc(100, 100, 80, 80, arc3.getStartAngle() + arc3.getLength(), grade[3] / 100 * 360);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.ORANGE);
        
        pane.getChildren().addAll(arc1, arc2, arc3, arc4, t1, t2, t3, t4);
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Pie Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
