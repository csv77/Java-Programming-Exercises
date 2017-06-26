package exercise_18_27;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise_18_27 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        KochTrianglePane pane = new KochTrianglePane();
        
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setAlignment(Pos.CENTER_RIGHT);
        tfOrder.setPrefColumnCount(4);
        
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order:"), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        
        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setTitle("Exercise_18_27");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.setOrder(0);
    }
    
    static class KochTrianglePane extends Pane {
        private int order = 0;
        private ObservableList<Node> list = getChildren();
        private double length = 200;
        
        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
            drawTriangle();
        }

        public KochTrianglePane() {
        }
        
        protected void drawTriangle() {
            Line line1 = new Line(getWidth() / 2, 0, getWidth() / 2 + length * Math.cos(Math.PI / 3), length * Math.sin(Math.PI / 3));
            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() - length, line1.getEndY());
            Line line3 = new Line(line2.getEndX(), line2.getEndY(), line1.getStartX(), line1.getStartY());
            list.clear();
            list.addAll(line1, line2, line3);
            linesToArray(order);
        }
        
        private void linesToArray(int order) {
            if(order == 0) {
                return;
            }
            else {
                Line[] lines = new Line[list.size()];
                for(int i = 0; i < list.size(); i++) {
                    lines[i] = (Line)(list.get(i));
                }
                for(Line line : lines) {
                    createNewLines(line);
                }
            }
            linesToArray(order - 1);
        }
        
        private void createNewLines(Line line) {
            double length2 = Math.sqrt(Math.pow(line.getStartX() - line.getEndX(), 2) + Math.pow(line.getStartY() - line.getEndY(), 2)) / 3;
            
            double dx = line.getEndX() - line.getStartX();
            double dy = line.getStartY() - line.getEndY();
            double alfa = Math.atan2(dy, dx);
            
            double x1 = line.getStartX() + length2 * Math.cos(alfa);
            double y1 = line.getStartY() - length2 * Math.sin(alfa);
            
            double x2 = line.getEndX() + length2 * Math.cos(alfa + Math.PI);
            double y2 = line.getEndY() - length2 * Math.sin(alfa + Math.PI);
            
            double x3 = x2 + length2 * Math.cos(alfa + Math.PI * 2 / 3);
            double y3 = y2 - length2 * Math.sin(alfa + Math.PI * 2 / 3);
            
            Line line1 = new Line(line.getStartX(), line.getStartY(), x1, y1);
            Line line2 = new Line(x1, y1, x3, y3);
            Line line3 = new Line(x3, y3, x2, y2);
            Line line4 = new Line(x2, y2, line.getEndX(), line.getEndY());
            
            list.remove(line);
            list.addAll(line1, line2, line3, line4);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
