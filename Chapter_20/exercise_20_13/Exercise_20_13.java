package exercise_20_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_20_13 extends Application {
    private Label lbExpression = new Label("Enter an expression: ");
    private Label lbStatus = new Label();
    private TextField tfExpression = new TextField();
    private Button btVerify = new Button("Verify");
    private Button btShuffle = new Button("Shuffle");
    private HBox hBox3 = new HBox(5);
    private ArrayList<String> cardValues = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(lbExpression, tfExpression, btVerify);
        
        lbStatus.setWrapText(true);
        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER_RIGHT);
        hBox2.getChildren().addAll(lbStatus, btShuffle);
        
        hBox3.setAlignment(Pos.CENTER);
        shuffleCards();
        
        btShuffle.setOnAction(e -> shuffleCards());
        btVerify.setOnAction(e -> setStatus());
        
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setTop(hBox2);
        pane.setBottom(hBox1);
        pane.setCenter(hBox3);
        
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Exercise_20_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void shuffleCards() {
        hBox3.getChildren().clear();
        lbStatus.setText("");
        tfExpression.clear();
        ArrayList<ImageView> listOfCards = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        listOfCards.clear();
        numbers.clear();
        cardValues.clear();
        while(numbers.size() != 4) {
            int number = (int)(Math.random() * 52 + 1);
            if(!numbers.contains(number)) {
                numbers.add(number);
                cardValues.add(number % 13 == 0 ? String.valueOf(13) : String.valueOf(number % 13));
                listOfCards.add(new ImageView("image/card/" + number + ".png"));
            }
        }
        hBox3.getChildren().addAll(listOfCards);
    }
    
    public void setStatus() {
        lbStatus.setText("");
        if(checkCardValues() && verifyValue(tfExpression.getText())) {
            lbStatus.setText("Correct");
        }
        else if(!checkCardValues()) {
            lbStatus.setText("The number in the expression don't match the number in the set");
        }
        else if(!verifyValue(tfExpression.getText())){
            lbStatus.setText("Incorrect result");
        }
        else {
            lbStatus.setText("Incorrect result and expression");
        }
    }
    
    public boolean checkCardValues() {
        String text = insertBlanks(tfExpression.getText());
        ArrayList<String> values = new ArrayList<>(Arrays.asList(text.split("[ ,+,-,*,/,(,)]")));
        values.removeAll(Arrays.asList("+", "-", "*", "/", "(", ")"));
        return values.containsAll(cardValues);
    }
    
    public boolean verifyValue(String expression) {
        return evaluateExpression(expression) == 24;
    }
    
    public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        expression = insertBlanks(expression);
        
        String[] tokens = expression.split(" ");

        for(String token: tokens) {
            if(token.length() == 0)
                continue;
            else if(token.charAt(0) == '+' || token.charAt(0) == '-') {
                while(!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' || 
                         operatorStack.peek() == '-' ||
                         operatorStack.peek() == '*' ||
                         operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if(token.charAt(0) == '*' || token.charAt(0) == '/') {
                while(!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if(token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            else if(token.trim().charAt(0) == ')') {
                while(operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            }
            else {
                operandStack.push(new Integer(token));
            }
        }
        while(!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if(op == '+') { 
            operandStack.push(op2 + op1);
        }    
        else if(op == '-') { 
            operandStack.push(op2 - op1);
        }
        else if(op == '*') { 
            operandStack.push(op2 * op1);
        }
        else if(op == '/') {
            operandStack.push(op2 / op1);
        }    
    }

    public static String insertBlanks(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == ')' || 
               s.charAt(i) == '+' || s.charAt(i) == '-' ||
               s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            }
            else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
