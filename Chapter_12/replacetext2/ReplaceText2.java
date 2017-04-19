package replacetext2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReplaceText2 {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 3) {
            System.out.println("Usage: java ReplaceText2 dir oldString newString");
            System.exit(1);
        }
        File dir = new File(args[0]);
        ArrayList<File> list = getFiles(dir);
        for(int i = 0; i < list.size(); i++){
            replaceTextInAFile(list.get(i), args[1], args[2]);
        }
    }
    
    public static ArrayList<File> getFiles(File dir) {
        if(!dir.isDirectory()) {
            System.out.println("Not existing directory");
            System.exit(2);
        }
        ArrayList<File> files = new ArrayList<>(Arrays.asList(dir.listFiles()));
        return files;
    }
    
    public static void replaceTextInAFile(File file, String old, String nw) throws FileNotFoundException{
        if(!file.exists()){
            System.out.println("The file " + file.getName() + " does not exists.");
            System.exit(2);
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        try(Scanner input = new Scanner(file);){
            while(input.hasNext()){
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(old, nw);
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
