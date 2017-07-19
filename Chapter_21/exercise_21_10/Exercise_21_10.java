package exercise_21_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Exercise_21_10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if(file.exists()) {
            try {
                System.out.println("The occurences of keywords in " + filename + ":");
                for(Map.Entry<String, Integer> entry : countKeywords(file).entrySet()) {
                    if(entry.getValue() != 0) {
                        System.out.printf("%-15s %4d \n", entry.getKey(), entry.getValue());
                    }
                }
            } catch(FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("File " + filename + " does not exist");
        }    
    }

    public static TreeMap<String, Integer> countKeywords(File file) throws FileNotFoundException  {  
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
        
        TreeMap<String, Integer> keywordMap = new TreeMap<>();
        for(String keyword : keywordString) {
            keywordMap.put(keyword, 0);
        }
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
            if(stack.isEmpty() && keywordMap.containsKey(word)){
                if(!keywordMap.containsKey(word)) {
                    keywordMap.put(word, 1);
                }
                else {
                    keywordMap.put(word, keywordMap.get(word) + 1);
                }
            }
        }
        return keywordMap;
    }
    
}
