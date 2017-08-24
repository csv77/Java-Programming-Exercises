package exercise_24_11;

import exercise_24_03.TwoWayLinkedList;
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

public class Exercise_24_11 extends Application {
    private TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
    private TextField tfValue = new TextField();
    private TextField tfIndex = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        TwoWayLinkedListPane pane = new TwoWayLinkedListPane();
        pane.repaint();
        
        tfValue.setPrefColumnCount(2);
        tfValue.setAlignment(Pos.BOTTOM_RIGHT);
        tfIndex.setPrefColumnCount(2);
        tfIndex.setAlignment(Pos.BOTTOM_RIGHT);
        Label lbValue = new Label("Enter a value:", tfValue);
        Label lbIndex = new Label("Enter an index:", tfIndex);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);
        lbIndex.setContentDisplay(ContentDisplay.RIGHT);
        
        Button btSearch = new Button("Search");
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btForward = new Button("Forward Traversal");
        Button btBackward = new Button("Backward Traversal");
        
        HBox hBoxForControl = new HBox(5);
        hBoxForControl.setAlignment(Pos.CENTER);
        hBoxForControl.getChildren().addAll(lbValue, lbIndex, btSearch, btInsert, btDelete, btForward, btBackward);
        
        Label lbStatus = new Label();
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        borderPane.setCenter(pane);
        borderPane.setBottom(hBoxForControl);
        
        Scene scene = new Scene(borderPane, 700, 250);
        primaryStage.setTitle("Exercise_24_11");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btSearch.setOnAction(e -> {
            try{
                if(!tfValue.getText().equals("")) {
                    Integer number = Integer.parseInt(tfValue.getText());
                    int index = list.indexOf(number);
                    if(index != -1) {
                        lbStatus.setText("The number is found in the list at index nr " + index + ".");
                    }
                    else {
                        lbStatus.setText("The list doesn't contain this number.");
                    }
                }
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can enter only integers! Try again!");
            }
        });
        
        btInsert.setOnAction(e -> {
            lbStatus.setText("");
            try{
                if(!tfValue.getText().equals("") && !tfIndex.getText().equals("")) {
                    Integer number = Integer.parseInt(tfValue.getText());
                    Integer index = Integer.parseInt(tfIndex.getText());
                    if(index < list.size()) {
                        list.add(index, number);
                    }
                    else {
                        list.addLast(number);
                    }
                }
                else if(!tfValue.getText().equals("") && tfIndex.getText().equals("")) {
                    Integer number = Integer.parseInt(tfValue.getText());
                    list.add(number);
                }
                pane.repaint();
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can enter only integers! Try again!");
            }
        });
        
        btDelete.setOnAction(e -> {
            lbStatus.setText("");
            try{
                if(tfValue.getText().equals("") && !tfIndex.getText().equals("")) {
                    int index = Integer.parseInt(tfIndex.getText());
                    if(!list.isEmpty() && index >= 0 && index < list.size()) {
                        list.remove(index);
                    }
                    else {
                        throw new IndexOutOfBoundsException();
                    }
                }
                else if(tfValue.getText().equals("") && tfIndex.getText().equals("") && !list.isEmpty()) {
                    list.removeFirst();
                }
                else {
                    if(list.isEmpty()) {
                        lbStatus.setText("The list is empty.");
                    }
                    else {
                        lbStatus.setText("Enter only an index.");
                    }
                }
                pane.repaint();
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can enter only integers! Try again!");
            }
            catch(IndexOutOfBoundsException ex) {
                lbStatus.setText("The index is out of range.");
            }
        });
    }
    
    public class TwoWayLinkedListPane extends Pane {
        private final double x = 40;
        private final double y = 80;
        private final double width = 60;
        private final double height = 20;
        private final double arrowLength = 30;
        
        public TwoWayLinkedListPane() {
            setStyle("-fx-border-color : black");
            setPadding(new Insets(5, 5, 10, 5));
        }
        
        public void repaint() {
            getChildren().clear();
            for(int i = 0; i < list.size(); i++) {
                drawNode(list.get(i).toString(), x + 1.5 * i * width, y);
                if(i < list.size() - 1) {
                    drawArrow(x + width * (1+ i * 1.5), y + height * 1.5, 0.5 * width / Math.cos(Math.toRadians(30)), 30);
                    drawArrow(x + (i * 1.5 + 1.5) * width, y + height * 2.5, 0.5 * width / Math.abs(Math.cos(Math.toRadians(125))), 125);
                }
                if(i == 0) {
                    drawHeadOrTail(i, 120, "head");
                }
                if(i == list.size() - 1) {
                    drawHeadOrTail(i, 60, "tail");
                }
            }
        }
        
        public void drawNode(String number, double startX, double startY) {
            for(int i = 0; i < 3; i++) {
                Rectangle node = new Rectangle(startX, startY + i * height, width, height);
                node.setStroke(Color.BLACK);
                node.setFill(Color.WHITE);
                getChildren().add(node);
            }
            Text tNumber = new Text(startX + width * 0.4, startY + height * 0.75, number);
            Text tNext = new Text(startX + width * 0.2, startY + height * 1.75, "next");
            Text tPrevious = new Text(startX + width * 0.1, startY + height * 2.75, "previous");
            
            getChildren().addAll(tNumber, tNext, tPrevious);
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
        
        public void drawHeadOrTail(int count, double alfa, String text) {
            double startX = x + count * width * 1.5 + 10 + arrowLength * Math.cos(Math.toRadians(alfa));
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
