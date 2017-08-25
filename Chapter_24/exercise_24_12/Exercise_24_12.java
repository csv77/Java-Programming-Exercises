package exercise_24_12;

import exercise_24_05.GenericQueue;
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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_24_12 extends Application {
    private TextField tfValue = new TextField();
    private GenericQueue<Integer> queue = new GenericQueue<>();
    private Label lbStatus = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        QueuePane pane = new QueuePane();
        pane.repaint();
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        
        Label lbValue = new Label("Enter a value:");
        Button btEnqueue = new Button("Enqueue");
        Button btDequeue = new Button("Dequeue");
        
        HBox hBoxForValue = new HBox(5);
        hBoxForValue.getChildren().addAll(tfValue, btEnqueue);
        lbValue.setGraphic(hBoxForValue);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);
        lbValue.setStyle("-fx-border-color : black");
        tfValue.setPrefColumnCount(3);
        tfValue.setAlignment(Pos.BASELINE_RIGHT);
        
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(lbValue, btDequeue);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        borderPane.setCenter(pane);
        
        BorderPane.setMargin(hBox, new Insets(5));
        
        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setTitle("Exercise_24_12");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btEnqueue.setOnAction(e -> {
            try {
                Integer number = Integer.parseInt(tfValue.getText());
                queue.enqueue(number);
                pane.repaint();
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can only enter integers.");
            }
        });
        
        btDequeue.setOnAction(e -> {
            if(queue.size() == 0) {
                lbStatus.setText("The queue is empty.");
            }
            else {
                lbStatus.setText("Dequeued integer: " + queue.dequeue());
                pane.repaint();
            }
        });
    }
    
    public class QueuePane extends Pane {
        private final double x = 20;
        private final double y = 80;
        private final double width = 30;
        private final double height = 20;
        private final double tailDegree = 50;
        private final double arrowLength = 40;
        
        public QueuePane() {
            setStyle("-fx-border-color : black");
            setPadding(new Insets(5, 5, 10, 5));
        }
        
        public void repaint() {
            getChildren().clear();
            if(queue.size() != 0) {
                for(int i = 0; i < queue.size(); i++) {
                    drawNode(queue.get(i).toString(), x + i * width, y);
                }
                
                drawHeadOrTail(0, 90, "head", arrowLength);
                drawHeadOrTail(queue.size() - 1, tailDegree, "tail",
                        arrowLength / Math.abs(Math.sin(Math.toRadians(tailDegree))));
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
        
        public void drawHeadOrTail(int count, double alfa, String text, double arrowLength) {
            double startX = x + count * width + 10 + arrowLength * Math.cos(Math.toRadians(alfa));
            double startY = y - arrowLength * Math.sin(Math.toRadians(alfa));
            drawArrow(startX, startY, arrowLength, alfa + 180);
            Text t = new Text(startX - 10, startY - 10, text);
            getChildren().add(t);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
