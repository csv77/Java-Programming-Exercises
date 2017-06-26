package exercise_18_35;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise_18_35 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HTreeFractalPane pane = new HTreeFractalPane();
        
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
        
        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Exercise_18_35");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.setOrder(0);
    }
    
    static class HTreeFractalPane extends Pane {
        private int order = 0;
        private double length = 200;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
            drawH();
        }

        public HTreeFractalPane() {
        }
        
        private void drawH() {
            getChildren().clear();
            double x = getWidth() * 0.5;
            double y = getHeight() * 0.5;
            
            drawH(x, y, order, length);
        }
        
        private void drawH(double x, double y, int order, double length) {
            Line line1 = new Line(x - length / 2, y, x + length / 2, y);
            Line line2 = new Line(line1.getStartX(), y - length / 2, line1.getStartX(), y + length / 2);
            Line line3 = new Line(line1.getEndX(), y - length / 2, line1.getEndX(), y + length / 2);
            getChildren().addAll(line1, line2, line3);
            
            if(order == 0) {
                return;
            }
            else {
                double newLength = length / 2;
                drawH(line2.getStartX(), line2.getStartY(), order - 1, newLength);
                drawH(line2.getEndX(), line2.getEndY(), order - 1, newLength);
                drawH(line3.getStartX(), line3.getStartY(), order - 1, newLength);
                drawH(line3.getEndX(), line3.getEndY(), order - 1, newLength);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
