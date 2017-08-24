package exercise_24_07;

import java.util.LinkedList;
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

public class Exercise_24_07 extends Application {
    private LinkedList<Integer> list = new LinkedList<>();
    private TextField tfValue = new TextField();
    private TextField tfIndex = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        LinkedListPane pane = new LinkedListPane();
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
        
        HBox hBoxForControl = new HBox(5);
        hBoxForControl.setAlignment(Pos.CENTER);
        hBoxForControl.getChildren().addAll(lbValue, lbIndex, btSearch, btInsert, btDelete);
        
        Label lbStatus = new Label();
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        borderPane.setCenter(pane);
        borderPane.setBottom(hBoxForControl);
        
        Scene scene = new Scene(borderPane, 600, 200);
        primaryStage.setTitle("Exercise_24_07");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btSearch.setOnAction(e -> {
            try{
                Integer number = Integer.parseInt(tfValue.getText());
                int index = list.indexOf(number);
                if(index != -1) {
                    lbStatus.setText("The number is found in the list at index nr " + index + ".");
                }
                else {
                    lbStatus.setText("The list doesn't contain this number.");
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
                if(!tfValue.getText().equals("") && tfIndex.getText().equals("")) {
                    Integer number = Integer.parseInt(tfValue.getText());
                    if(list.contains(number)) {
                        list.remove(number);
                    }
                    else if(!list.isEmpty()){
                        lbStatus.setText("The list doesn't contain this number.");
                    }
                    else {
                        lbStatus.setText("The list is still empty.");
                    }
                }
                else if(tfValue.getText().equals("") && !tfIndex.getText().equals("")) {
                    int index = Integer.parseInt(tfIndex.getText());
                    if(!list.isEmpty() && index >= 0 && index < list.size()) {
                        list.remove(index);
                    }
                    else {
                        if(list.isEmpty()) {
                            lbStatus.setText("The list is still empty.");
                        }
                        else if(index < 0 || index >= list.size()) {
                            lbStatus.setText("The index is out of range.");
                        }
                    }
                }
                else if(tfValue.getText().equals("") && tfIndex.getText().equals("") && !list.isEmpty()) {
                    list.remove();
                }
                else {
                    if(list.isEmpty()) {
                        lbStatus.setText("The list is empty.");
                    }
                    else {
                        lbStatus.setText("Enter only a number or an index.");
                    }
                }
                pane.repaint();
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can enter only integers! Try again!");
            }
        });
    }
    
    public class LinkedListPane extends Pane {
        private final double x = 40;
        private final double y = 80;
        private final double width = 30;
        private final double height = 20;
        private final double arrowLength = 30;
        
        public LinkedListPane() {
            setStyle("-fx-border-color : black");
            setPadding(new Insets(5, 5, 10, 5));
        }
        
        public void repaint() {
            getChildren().clear();
            for(int i = 0; i < list.size(); i++) {
                drawNode(list.get(i).toString(), x + 2.5 * i * width, y);
                if(i < list.size() - 1) {
                    drawArrow(x + width * (1.25 + i * 2.5), y + height * 0.5, 1.25 * width, 0);
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
            Rectangle node = new Rectangle(startX, startY, width, height);
            node.setStroke(Color.BLACK);
            node.setFill(Color.WHITE);
            
            Text tNumber = new Text(startX + width * 0.4, startY + height * 0.75, number);
            
            Rectangle link = new Rectangle(startX + width, y, width / 2, height);
            link.setStroke(Color.BLACK);
            link.setFill(Color.TRANSPARENT);
            
            getChildren().addAll(node, link, tNumber);
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
            double startX = x + count * width * 2.5 + 10 + arrowLength * Math.cos(Math.toRadians(alfa));
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
