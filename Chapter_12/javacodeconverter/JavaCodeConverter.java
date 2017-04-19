package javacodeconverter;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaCodeConverter {

    public static void main(String[] args) throws Exception{
        if(args.length != 1){
            System.out.println("Usage: java .java filename");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("The file " + args[0] + " does not exists.");
            System.exit(2);
        }
        
        ArrayList<String> list = new ArrayList<>();
        String string1 = "";
        String string2 = "";
        
        try(Scanner input = new Scanner(file)){
            string1 = input.nextLine();
            while(input.hasNext()){
                string2 = input.nextLine();
                //if(string2.length() > 0 && string2.charAt(string2.length() - 1) == '{'){
                if(hasOnlyOpenBracket(string2)){
                    list.add(string1 + " {");
                    string1 = input.nextLine();
                }
                else{
                    list.add(string1);
                    string1 = string2;
                }
            }
            list.add(string1);
        }
        
        try(PrintWriter output = new PrintWriter(file)){
            for(int i = 0; i < list.size(); i++){
                output.println(list.get(i));
            }
        }
    }
    
    public static boolean hasOnlyOpenBracket(String text){
        for(int i = 0; i < text.length(); i++){
            if(!(Character.isWhitespace(text.charAt(i))) && !(text.charAt(i) == '{')){
                return false;
            }
        }
        return true;
    }
}
