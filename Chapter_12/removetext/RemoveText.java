package removetext;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveText {

    public static void main(String[] args) throws Exception{
        if(args.length != 2){
            System.out.println("Usage: java RemoveText filename");
            System.exit(1);
        }
        File file = new File(args[1]);
        if(!file.exists()){
            System.out.println("The file " + args[1] + " does not exists.");
            System.exit(2);
        }
        ArrayList<String> s2 = new ArrayList<>();
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String s1 = input.nextLine();
                s2.add(removeText(args[0], s1));
            }
        }
        try(PrintWriter output = new PrintWriter(file)){
            for(int i = 0; i < s2.size(); i++){
                output.println(s2.get(i));
            }
        }
        
    }
    
    public static String removeText(String string, String stringText){
        StringBuilder text = new StringBuilder(stringText);
        int start = text.indexOf(string);
        int end = string.length();
        while(start >= 0){
            end += start;
            text = text.delete(start, end);
            start = text.indexOf(string, start);
        }
        return text.toString();
    }
    
}
