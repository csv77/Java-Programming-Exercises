package exercise_20_16;

import java.util.LinkedList;
import java.util.Stack;

public class Exercise_20_16 {

    public static void main(String[] args) {
        
    }
    
    public static String infixToPostfix(String expression) {
        String[] tokens = insertBlanks(expression).split(" ");
        LinkedList<String> operators = new LinkedList<>();
        LinkedList<String> operands = new LinkedList<>();
        Stack<Character> parentheses = new Stack<>();
        
        for(String token : tokens) {
            if(token.length() == 0) {
                continue;
            }
            if(token.charAt(0) == '(') {
                parentheses.push(token.charAt(0));
            }
            else if(!parentheses.empty() && parentheses.peek() == '(' && token.charAt(0) != ')') {
                if(Character.isDigit(token.charAt(0))) {
                    operands.addLast(token);
                }
                else if() {
                    
                }
                
            }
            
            
        }
        
        
    }
    
    public static String insertBlanks(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+' || s.charAt(i) == '-' ||
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
