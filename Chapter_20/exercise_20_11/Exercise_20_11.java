package exercise_20_11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Exercise_20_11 {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java Exercise_20_11 sourceFile");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists()) {
            System.out.println("File " + args[0] + " doesn't exists");
            System.exit(2);
        }
        
        ArrayList<String> symbols = new ArrayList<>(Arrays.asList("(", ")", "[", "]", "{", "}"));
        Stack<String> stack = new Stack<>();
            
        try(BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while((line = input.readLine()) != null) {
                for(int i = 0; i < line.length(); i++) {
                    String s = line.substring(i, i + 1);
                    int symbolIndex = symbols.indexOf(s);
                    if(!symbols.contains(s)) {
                        continue;
                    }
                    if(stack.isEmpty()) {
                        stack.push(s);
                    }
                    else {
                        int previousIndex = symbols.indexOf(stack.peek());
                        if(symbolIndex - 1 == previousIndex) {
                            stack.pop();
                        }
                        else {
                            if((symbolIndex % 2) == 1) {
                                System.out.println("Wrong symbol: " + s);
                            }
                            else {
                                stack.push(s);
                            }
                        }
                    }
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        if(stack.isEmpty()) {
            System.out.println("There aren't any symbol mistake in file: " + file.toString());
        }
    }
}
