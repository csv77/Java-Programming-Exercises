package simplecalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    private TextField t1 = new TextField();
    private TextField t2 = new TextField();
    private TextField t3 = new TextField();
    private Button b1 = new Button("Add");
    private Button b2 = new Button("Subtract");
    private Button b3 = new Button("Multiply");
    private Button b4 = new Button("Divide");
            
    @Override
    public void start(Stage primaryStage) {
        HBox hBox1 = new HBox(5);
        HBox hBox2 = new HBox(5);
        VBox vBox = new VBox(15);
        hBox1.getChildren().addAll(new Label("Number1:"), t1, new Label("Number2:"), t2, new Label("Result:"), t3);
        hBox2.getChildren().addAll(b1, b2, b3, b4);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.getChildren().addAll(hBox1, hBox2);
                
        t1.setPrefColumnCount(6);
        t2.setPrefColumnCount(6);
        t3.setPrefColumnCount(6);
        t3.setEditable(false);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        
        b1.setOnAction(e -> add());
        b2.setOnAction(e -> subtract());
        b3.setOnAction(e -> multiply());
        b4.setOnAction(e -> divide());
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void add() {
        t3.setText(String.format("%.4f", Double.parseDouble(t1.getText()) + Double.parseDouble(t2.getText())));
    }
    
    public void subtract() {
        t3.setText(String.format("%.4f", Double.parseDouble(t1.getText()) - Double.parseDouble(t2.getText())));
    }
    
    public void multiply() {
        t3.setText(String.format("%.4f", Double.parseDouble(t1.getText()) * Double.parseDouble(t2.getText())));
    }
    
    public void divide() {
        t3.setText(String.format("%.4f", Double.parseDouble(t1.getText()) / Double.parseDouble(t2.getText())));
    }
}
