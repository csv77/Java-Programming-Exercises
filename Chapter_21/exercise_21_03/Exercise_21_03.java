package exercise_21_03;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Exercise_21_03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if(file.exists()) {
            try {
                System.out.println("The number of keywords in " + filename
                        + " is " + countKeywords(file));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("File " + filename + " does not exist");
        }    
    }

    public static int countKeywords(File file) throws Exception {  
        String[] keywordString = {"abstract", "assert", "boolean", 
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int", 
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", 
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;    
        Scanner input = new Scanner(file);

        while(input.hasNext()) {
            String word = input.next();
            if(word.substring(0, 2).equals("//")) {
                input.nextLine();
            }
            
            Stack<String> stack = new Stack<>();
            
            if(stack.isEmpty() && word.substring(0, 1).equals("\"")) {
                stack.push("\"");
            }
            else if(word.substring(0, 1).equals("\"")) {
                stack.pop();
            }
            if(stack.isEmpty() && word.substring(0, 2).equals("/*")) {
                stack.push("/*");
            }
            else if(word.substring(0, 2).equals("*/")) {
                stack.pop();
            }
            if(stack.isEmpty() && keywordSet.contains(word)){
                count++;
                System.out.println(word);
            }
        }
        return count;
    }
}
