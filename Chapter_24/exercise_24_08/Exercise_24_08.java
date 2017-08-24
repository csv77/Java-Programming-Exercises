package exercise_24_08;

import exercise_24_01.MyArrayList;
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

public class Exercise_24_08 extends Application {
    private MyArrayList<Integer> list = new MyArrayList<>();
    private TextField tfValue = new TextField();
    private TextField tfIndex = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        ArrayListPane pane = new ArrayListPane();
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
        Button btTrim = new Button("TrimToSize");
        
        HBox hBoxForControl = new HBox(5);
        hBoxForControl.setAlignment(Pos.CENTER);
        hBoxForControl.getChildren().addAll(lbValue, lbIndex, btSearch, btInsert, btDelete, btTrim);
        
        Label lbStatus = new Label();
        lbStatus.setText("size = " + list.size() + " and capacity is " + list.getCapacity());
        
        borderPane.setTop(lbStatus);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        borderPane.setCenter(pane);
        borderPane.setBottom(hBoxForControl);
        
        Scene scene = new Scene(borderPane, 600, 200);
        primaryStage.setTitle("Exercise_24_08");
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
                    if(index < list.size() && index >= 0) {
                        list.add(index, number);
                        lbStatus.setText("size = " + list.size() + " and capacity is " + list.getCapacity());
                    }
                    else {
                        throw new IndexOutOfBoundsException();
                    }
                }
                else if(!tfValue.getText().equals("") && tfIndex.getText().equals("")) {
                    Integer number = Integer.parseInt(tfValue.getText());
                    list.add(number);
                    lbStatus.setText("size = " + list.size() + " and capacity is " + list.getCapacity());
                }
                pane.repaint();
            }
            catch(NumberFormatException ex) {
                lbStatus.setText("You can enter only integers! Try again!");
            }
            catch(IndexOutOfBoundsException ex) {
                lbStatus.setText("Invalid index, it is out of the range of the list");
            }
        });
        
        btDelete.setOnAction(e -> {
            lbStatus.setText("");
            try{
                if(!tfValue.getText().equals("") && tfIndex.getText().equals("")) {
                    Integer number = Integer.parseInt(tfValue.getText());
                    if(list.contains(number)) {
                        list.remove(number);
                        lbStatus.setText("size = " + list.size() + " and capacity is " + list.getCapacity());
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
                        lbStatus.setText("size = " + list.size() + " and capacity is " + list.getCapacity());
                    }
                    else {
                        if(list.isEmpty()) {
                            lbStatus.setText("The list is still empty.");
                        }
                        else if(index < 0 || index >= list.size()) {
                            throw new IndexOutOfBoundsException();
                        }
                    }
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
            catch(IndexOutOfBoundsException ex) {
                lbStatus.setText("Invalid index, it is out of the range of the list");
            }
        });
        
        btTrim.setOnAction(e -> {
            list.trimToSize();
            pane.repaint();
            lbStatus.setText("size = " + list.size() + " and capacity is " + list.getCapacity());
        });
    }
    
    public class ArrayListPane extends Pane {
        private final double x = 40;
        private final double y = 80;
        private final double width = 30;
        private final double height = 20;
        
        public ArrayListPane() {
            setStyle("-fx-border-color : black");
            setPadding(new Insets(5, 5, 10, 5));
        }
        
        public void repaint() {
            getChildren().clear();
            for(int i = 0; i < list.getCapacity(); i++) {
                if(i < list.size()) {
                    drawNode(list.get(i).toString(), x + i * width, y);
                }
                else {
                    drawNode("", x + i * width, y);
                }
            }
        }
        
        public void drawNode(String number, double startX, double startY) {
            Rectangle node = new Rectangle(startX, startY, width, height);
            node.setStroke(Color.BLACK);
            node.setFill(Color.WHITE);
            getChildren().add(node);
            
            if(number.equals("")) {
                Line line = new Line(startX, startY + height, startX + width, startY);
                getChildren().add(line);
            }
            else {
                Text tNumber = new Text(startX + width * 0.4, startY + height * 0.75, number);
                getChildren().add(tNumber);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
