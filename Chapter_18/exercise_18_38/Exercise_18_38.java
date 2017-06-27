package exercise_18_38;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise_18_38 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        RecursiveTreePane pane = new RecursiveTreePane();
        
        TextField tfOrder = new TextField("0");
        tfOrder.setOnAction(e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.DOWN && Integer.parseInt(tfOrder.getText()) > 0) {
                tfOrder.setText("" + (Integer.parseInt(tfOrder.getText()) - 1));
            }
            if(e.getCode() == KeyCode.UP) {
                tfOrder.setText("" + (Integer.parseInt(tfOrder.getText()) + 1));
            }
            pane.setOrder(Integer.parseInt(tfOrder.getText()));
        });
                
        tfOrder.setAlignment(Pos.CENTER_RIGHT);
        tfOrder.setPrefColumnCount(4);
        
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order:"), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        
        Scene scene = new Scene(borderPane, 300, 350);
        primaryStage.setTitle("Exercise_18_38");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.setOrder(0);
    }
    
    static class RecursiveTreePane extends Pane {
        private int order = 0;
        private double length = 180;
        private double angle = Math.PI / 2;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
            draw();
        }

        public RecursiveTreePane() {
        }
        
        private void draw() {
            getChildren().clear();
            draw(order, getWidth() / 2, getHeight() - 10, length, angle);
        }
        
        private void draw(int order, double x, double y, double length, double angle) {
            double newLength = length * 0.6;
            Line line1 = new Line(x, y, x + newLength * Math.cos(angle), y - newLength * Math.sin(angle));
            getChildren().addAll(line1);
                    
            if(order == 0) {
                return;
            }
            else {
                draw(order - 1, line1.getEndX(), line1.getEndY(), newLength, angle - Math.PI / 5);
                draw(order - 1, line1.getEndX(), line1.getEndY(), newLength, angle + Math.PI / 5);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
