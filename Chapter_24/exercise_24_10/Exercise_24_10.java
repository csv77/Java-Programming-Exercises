package exercise_24_10;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class Exercise_24_10 extends Application {
    private TextField tfValue = new TextField();
    private Stack<Integer> stack = new Stack<>();
    private Label lbStatus = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        StackPane pane = new StackPane();
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        Label lbValue = new Label("Enter a value:");
        Button btPush = new Button("Push");
        Button btPop = new Button("Pop");
        
        HBox hBoxForValue = new HBox(5);
        hBoxForValue.getChildren().addAll(tfValue, btPush);
        lbValue.setGraphic(hBoxForValue);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);
        lbValue.setStyle("-fx-border-color : black");
        tfValue.setPrefColumnCount(3);
        tfValue.setAlignment(Pos.BASELINE_RIGHT);
        
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(lbValue, btPop);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        borderPane.setCenter(pane);
        
        BorderPane.setMargin(hBox, new Insets(5));
        
        Scene scene = new Scene(borderPane, 400, 500);
        primaryStage.setTitle("Exercise_24_10");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.repaint();
        
        btPush.setOnAction(e -> {
            try{
                lbStatus.setText("");
                Integer number = Integer.parseInt(tfValue.getText());
                stack.push(number);
                pane.repaint();
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can enter only integer.");
            }
        });
        
        btPop.setOnAction(e -> {
            try{
                lbStatus.setText("Returned integer: " + stack.pop());
                pane.repaint();
            }
            catch(EmptyStackException ex) {
                lbStatus.setText("The stack is already empty.");
            }
        });
    }
    
    public class StackPane extends Pane {
        private final double width = 30;
        private final double height = 20;
        
        public StackPane() {
            setStyle("-fx-border-color : black");
            setPadding(new Insets(5, 5, 10, 5));
        }
        
        public void repaint() {
            getChildren().clear();
            if(stack.size() != 0) {
                ArrayList<Integer> list = new ArrayList<>(stack);
                for(int i = list.size() - 1; i >= 0; i--) {
                    drawNode(list.get(i).toString(), getWidth() / 2 - width / 2, getHeight() - 40 - i * height);
                }
                double startX = getWidth() / 2 - width / 2 - 40;
                double startY = getHeight() - 30 - (list.size() - 1) * height;
                drawArrow(startX, startY, 40, 0);
                Text text = new Text(startX - 25, startY + 5, "Top");
                getChildren().add(text);
            }
        }
        
        public void drawNode(String number, double startX, double startY) {
            Rectangle node = new Rectangle(startX, startY, width, height);
            node.setStroke(Color.BLACK);
            node.setFill(Color.WHITE);
            getChildren().add(node);
            
            Text tNumber = new Text(startX + width * 0.4, startY + height * 0.75, number);
            getChildren().add(tNumber);
        }
        
        public void drawArrow(double startX, double startY, double length, double alfa) {
            double endX = startX + length * Math.cos(Math.toRadians(alfa));
            double endY = startY - length * Math.sin(Math.toRadians(alfa));
            Line line = new Line(startX, startY, endX, endY);
            
            double endLeftX = endX + 10 * Math.cos(Math.toRadians(alfa - 180 + 45));
            double endLeftY = endY - 10 * Math.sin(Math.toRadians(alfa - 180 + 45));
            
            double endRightX = endX + 10 * Math.cos(Math.toRadians(alfa - 180 - 45));
            double endRightY = endY - 10 * Math.sin(Math.toRadians(alfa - 180 - 45));
            
            Line lineLeft = new Line(endX, endY, endLeftX, endLeftY);
            Line lineRight = new Line(endX, endY, endRightX, endRightY);
            
            getChildren().addAll(line, lineLeft, lineRight);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
