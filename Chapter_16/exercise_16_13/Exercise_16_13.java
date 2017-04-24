package exercise_16_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_16_13 extends Application {
    private TextField tfAmount = new TextField();
    private TextField tfYears = new TextField();
    private TextArea taForData = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        HBox paneForData = new HBox(5);
        
        Label loanAmount = new Label("Loan amount", tfAmount);
        loanAmount.setContentDisplay(ContentDisplay.RIGHT);
        tfAmount.setPrefColumnCount(8);
        
        Label numberOfYears = new Label("Number of Years", tfYears);
        numberOfYears.setContentDisplay(ContentDisplay.RIGHT);
        tfYears.setPrefColumnCount(2);
        
        Button btShowTable = new Button("Show Table");
        paneForData.getChildren().addAll(loanAmount, numberOfYears, btShowTable);
        
        taForData.setPrefColumnCount(40);
        ScrollPane scrollPane = new ScrollPane(taForData);
        pane.setTop(paneForData);
        pane.setCenter(scrollPane);
        
        btShowTable.setOnAction(e -> printData());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Compare loans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void printData() {
        double loanAmount = Double.parseDouble(tfAmount.getText());
        int numberOfYs = Integer.parseInt(tfYears.getText());
        String text = "Interest Rate\tMonthly Payment\tTotal Payment\n";
        for(double rate = 5.0; rate <= 8.0; rate += 0.125) {
            double monthlyInterestRate = rate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYs * 12));
            double totalPayment = monthlyPayment * numberOfYs * 12;
            text += String.format("%-1.3f\t\t%-3.2f\t\t\t%-5.2f\n", rate, monthlyPayment, totalPayment);
        }
        taForData.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
