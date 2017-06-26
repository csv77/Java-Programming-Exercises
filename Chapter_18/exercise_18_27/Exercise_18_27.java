package exercise_18_27;

import javafx.application.Application;
import javafx.collections.ObservableList;
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
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        
        Scene scene = new Scene(borderPane, 220, 220);
        primaryStage.setTitle("Exercise_18_27");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.setOrder(0);
        
    }
    
    static class KochTrianglePane extends Pane {
        private int order = 0;
        ObservableList<Node> list = getChildren();
        
        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        public KochTrianglePane() {
        }
        
        protected void paint() {
            double length = 200;
            Line line1 = new Line(getWidth() / 2, 5, getWidth() / 2 + length * Math.cos(Math.PI / 3), 5 + length * Math.sin(Math.PI / 3));
            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() - length, line1.getEndY());
            Line line3 = new Line(line2.getEndX(), line2.getEndY(), line1.getStartX(), line1.getStartY());
            list.clear();
            list.addAll(line1, line2, line3);
            displayTriangles(order);
        }
        
        private void displayTriangles(int order) {
            if(order == 0) {
                return;
            }
            else {
                
            }
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
