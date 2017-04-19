package tworectangles;

import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoRectangles extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scanner input = new Scanner(System.in);
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(10, 5, 5, 10));
        
        Rectangle r1 = getRectangle(input);
        Rectangle r2 = getRectangle(input);
        String text = "   ";
        if(contains(r1, r2) || contains(r2, r1)) {
            text += "One rectangle is contained in another";
        }
        else if(overlaps(r1, r2)) {
            text += "The rectangles overlap";
        }
        else {
            text += "The rectangles do not overlap";
        }
        
        pane.getChildren().addAll(r1, r2);
        vBox.getChildren().addAll(pane, new Text(text));
        Scene scene = new Scene(vBox);
        
        primaryStage.setTitle("Two rectangles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static boolean overlaps(Rectangle r1, Rectangle r2) {
        return getDistance(r1.getX(), r2.getX() + r2.getWidth()) < r1.getWidth() + r2.getWidth() &&
               getDistance(r1.getY(), r2.getY() + r2.getHeight()) < r1.getHeight() + r2.getHeight();
    }
    
    public static boolean contains(Rectangle r1, Rectangle r2) {
        return r2.getX() + r2.getWidth() <= r1.getX() + r1.getWidth() &&
               r2.getY() + r2.getHeight() <= r1.getY() + r1.getHeight() &&
               r2.getX() > r1.getX() &&
               r2.getY() > r1.getY();
    }
    
    public static double getDistance(double p1, double p2) {
        return Math.abs(p2 - p1);
    }
    
    public static Rectangle getRectangle(Scanner input) {
        System.out.print("Type in the center coordinates, width and height of the Rectangle: ");
        double centerX = input.nextDouble();
        double centerY = input.nextDouble();
        double width = input.nextDouble();
        double height = input.nextDouble();
        Rectangle r = new Rectangle(centerX - width / 2, centerY - height / 2, width, height);
        r.setStroke(Color.BLACK);
        r.setFill(null);
        return r;
    }
    
}
