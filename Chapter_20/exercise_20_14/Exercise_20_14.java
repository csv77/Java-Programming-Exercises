package exercise_20_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class Exercise_20_14 {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java Exercise_20_14 \"expression\"");
            System.exit(1);
        }
        
        Stack<Integer> operandStack = new Stack<>();
        ArrayList<Character> operators = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
        String[] tokens = insertBlanks(args[0]).split(" ");
        
        for(String token : tokens) {
            if(token.length() == 0) {
                continue;
            }
            if(!operators.contains(token.charAt(0)) && !token.equals(" ")) {
                operandStack.push(new Integer(token));
            }
            else if(operators.contains(token.charAt(0))) {
                char op = token.charAt(0);
                int op1 = 0;
                int op2 = 0;
                try {
                    op1 = operandStack.pop();
                    op2 = operandStack.pop();
                } catch (EmptyStackException e) {
                    System.out.println("Wrong expression: " + args[0]);
                    System.exit(2);
                }
                switch (op) {
                    case '+':
                        operandStack.push(op2 + op1);
                        break;
                    case '-':
                        operandStack.push(op2 - op1);
                        break;
                    case '*':
                        operandStack.push(op2 * op1);
                        break;
                    case '/':
                        operandStack.push(op2 / op1);
                        break;
                    default:
                        break;
                }
            }
            else {
                System.out.println("Wrong expression" + args[0]);
                System.exit(2);
            }
        }
        System.out.println("The result is: " + operandStack.pop());
        
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
