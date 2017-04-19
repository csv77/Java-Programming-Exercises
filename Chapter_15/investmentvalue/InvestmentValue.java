package investmentvalue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestmentValue extends Application {
    private TextField tfInvestmentAmount = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfFutureValue = new TextField();
    private Button btCalculate = new Button("Calculate");
           
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Investment Amount: "), 0, 0);
        pane.add(tfInvestmentAmount, 1, 0);
        pane.add(new Label("Number of Years"), 0, 1);
        pane.add(tfNumberOfYears, 1, 1);
        pane.add(new Label("Annual Interest Rate"), 0, 2);
        pane.add(tfAnnualInterestRate, 1, 2);
        pane.add(new Label("Future value:"), 0, 3);
        pane.add(tfFutureValue, 1, 3);
        pane.add(btCalculate, 1, 4);
        
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        tfInvestmentAmount.setAlignment(Pos.CENTER_RIGHT);
        tfNumberOfYears.setAlignment(Pos.CENTER_RIGHT);
        tfAnnualInterestRate.setAlignment(Pos.CENTER_RIGHT);
        tfFutureValue.setAlignment(Pos.CENTER_RIGHT);
        tfFutureValue.setEditable(false);
        
        btCalculate.setOnAction(e -> calculate());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Investment value calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void calculate() {
        double futureValue = Double.parseDouble(tfInvestmentAmount.getText()) * 
                Math.pow(1 + Double.parseDouble(tfAnnualInterestRate.getText()) / 1200, Double.parseDouble(tfNumberOfYears.getText()) * 12);
        tfFutureValue.setText(String.format("$%.2f", futureValue));
    }
}
