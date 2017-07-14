package exercise_20_16;

import java.util.Stack;

public class Exercise_20_16 {

    public static void main(String[] args) {
        System.out.println("Infix Expression\tPostfix Expression");
	System.out.println("(1 * 2 + 2) * 3\t\t" + infixToPostfix("(1 * 2 + 2) * 3"));
	System.out.println("2 * (1 * 2 + 3)\t\t" + infixToPostfix("2 * (1 * 2 + 3)"));
    }
    
    public static String infixToPostfix(String expression) {
        String[] tokens = insertBlanks(expression).split(" ");
        Stack<Character> operatorStack = new Stack<>();
        String result = "";
        
        for(String token : tokens) {
            if(token.length() == 0) {
                continue;
            }
            
            if(Character.isDigit(token.charAt(0))) {
                result += token;
            }
            
            if(token.charAt(0) == '(') {
                operatorStack.push(token.charAt(0));
            }
            
            if(token.charAt(0) == ')') {
                while(operatorStack.peek() != '(') {
                    result += operatorStack.pop();
                }
                operatorStack.pop();
            }
            
            if(operatorStack.isEmpty() || operatorStack.peek() == '(') {
                if(isOperator(token.charAt(0))) {
                    operatorStack.push(token.charAt(0));
                }
            }
            else if(token.charAt(0) == '*' || token.charAt(0) == '/') {
                if(!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-')) {
                    operatorStack.push(token.charAt(0));
                }
                else if(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    result += operatorStack.pop();
                    operatorStack.push(token.charAt(0));
                }
            }
            else if(token.charAt(0) == '+' || token.charAt(0) == '-') {
                if(!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-')) {
                    result += operatorStack.pop();
                    operatorStack.push(token.charAt(0));
                }
                else if(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    while(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                        result += operatorStack.pop();
                    }
                    operatorStack.push(token.charAt(0));
                }
            }
        }
        while(!operatorStack.isEmpty()) {
            result += operatorStack.pop();
        }
        return result;
    }
    
    public static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }
    
    public static String insertBlanks(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/' ||
                    s.charAt(i) == '(' || s.charAt(i) == ')') {
                result += " " + s.charAt(i) + " ";
            }
            else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
