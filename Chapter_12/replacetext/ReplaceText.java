package replacetext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplaceText {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 3){
            System.out.println("Usage: java filename oldStr newStr");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("The file " + file.getName() + " does not exists.");
            System.exit(2);
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        try(Scanner input = new Scanner(file);){
            while(input.hasNext()){
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);
                list.add(s2);
            }
        }
        
        try(PrintWriter output = new PrintWriter(file);){
            for(int i = 0; i < list.size(); i++){
                output.println(list.get(i));
            }
        }
        
    }
}
