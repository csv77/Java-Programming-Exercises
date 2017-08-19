package exercise_23_18;

import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_23_18 extends Application {
    private static final int SIZE = 8;
    private static final int INTERVAL = 999;
    private int current1 = 0;
    private int current2 = 0;
    private int current3 = 0;
    private int[] list1 = new int[SIZE];
    private int[] list2 = new int[SIZE];
    private int[] temp = new int[SIZE * 2];
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        createLists();
        PaneForMerge paneForMerge = new PaneForMerge();
        paneForMerge.repaint();
        
        Label lbStatus = new Label();
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        
        HBox hBoxForButtons = new HBox(5);
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.getChildren().addAll(btStep, btReset);
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        borderPane.setBottom(hBoxForButtons);
        borderPane.setCenter(paneForMerge);
        
        Scene scene = new Scene(borderPane, 550, 250);
        primaryStage.setTitle("Exercise_23_18");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btStep.setOnAction(e -> {
            if(mergeStep() == 1){
                paneForMerge.repaint();
            }
            else {
                lbStatus.setText("The lists are already merged.");
            }
        });
        
        btReset.setOnAction(e -> {
            createLists();
            paneForMerge.repaint();
            lbStatus.setText("");
        });
    }
    
    public void createLists() {
        for(int i = 0; i < list1.length; i++) {
            list1[i] = (int)(Math.random() * INTERVAL + 1);
            list2[i] = (int)(Math.random() * INTERVAL + 1);
            current1 = 0;
            current2 = 0;
            current3 = 0;
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
    }
    
    public int mergeStep() {
        if(current1 < list1.length && current2 < list2.length) {
            if(list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
                return 1;
            }
            else {
                temp[current3++] = list2[current2++];
                return 1;
            }
        }
        else if(current1 < list1.length && current2 >= list2.length) {
            temp[current3++] = list1[current1++];
            return 1;
        }
        else if(current2 < list2.length && current1 >= list1.length) {
            temp[current3++] = list2[current2++];
            return 1;
        }
        return 2;
    }
    
    class PaneForMerge extends Pane {
        private int x = 20;
        private int y = 60;
        private double width = 25;
        private double height = 15;
        
        public PaneForMerge() {
            this.setStyle("-fx-border-color : black");
            this.setPadding(new Insets(0, 0, 0, 10));
        }
        
        public void repaint() {
            getChildren().clear();
            Text tList1 = new Text(x, y, "list1");
            Text tList2 = new Text(x + SIZE * width + 40, y, "list2");
            Text tTemp = new Text(x - 8, y + 30, "temp");
            getChildren().addAll(tList1, tList2, tTemp);
            
            for(int i = 0; i < list1.length; i++) {
                Rectangle rectangle = new Rectangle(x + 25 + i * width, y - 13, width, height);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                Text text = new Text(x + 27 + i * width, y, list1[i] + "");
                getChildren().addAll(rectangle, text);
            }
            
            for(int i = 0; i < list2.length; i++) {
                Rectangle rectangle = new Rectangle(tList2.getX() + 25 + i * width, y - 13, width, height);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                Text text = new Text(tList2.getX() + 27 + i * width, y, list2[i] + "");
                getChildren().addAll(rectangle, text);
            }
            
            for(int i = 0; i < temp.length; i++) {
                Rectangle rectangle = new Rectangle(tTemp.getX() + 33 + i * width, tTemp.getY() - 13, width, height);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                getChildren().addAll(rectangle);
            }
            
            for(int i = 0; i < current3; i++) {
                Text text = new Text(tTemp.getX() + 35 + i * width, tTemp.getY(), temp[i] + "");
                getChildren().add(text);
            }
            
            if(current1 < 8) {
                drawArrow(20, x + 37 + current1 * width, y - 13, true);
                getChildren().add(new Text(x + 27 + current1 * width, y - 33, "current1"));
            }
            else {
                drawArrow(20, x + 37 + 7 * width, y - 13, true);
                getChildren().add(new Text(x + 27 + 7 * width, y - 33, "current1"));
            }
            
            if(current2 < 8) {
                drawArrow(20, x + 77 + (8 + current2) * width, y - 13, true);
                getChildren().add(new Text(x + 67 + (8 + current2) * width, y - 33, "current2"));
            }
            else {
                drawArrow(20, x + 77 + (8 + 7) * width, y - 13, true);
                getChildren().add(new Text(x + 67 + (8 + 7) * width, y - 33, "current2"));
            }
            
            if(current3 < 16) {
                drawArrow(20, x + 37 + current3 * width, tTemp.getY() + 2, false);
                getChildren().add(new Text(x + 27 + current3 * width, y + 60, "current3"));
            }
            else {
                drawArrow(20, x + 37 + 15 * width, tTemp.getY() + 2, false);
                getChildren().add(new Text(x + 27 + 15 * width, y + 60, "current3"));
            }
        }
        
        public void drawArrow(double length, double x1, double y1, boolean down) {
            if(down) {
                Polyline polyline = new Polyline(x1 - 5, y1 - 5, x1, y1, x1 + 5, y1 - 5);
                Line line = new Line(x1, y1, x1, y1 - length);
                getChildren().addAll(polyline, line);
            }
            else {
                Polyline polyline = new Polyline(x1 - 5, y1 + 5, x1, y1, x1 + 5, y1 + 5);
                Line line = new Line(x1, y1, x1, y1 + length);
                getChildren().addAll(polyline, line);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
