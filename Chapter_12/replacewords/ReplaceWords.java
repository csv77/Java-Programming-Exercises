package replacewords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReplaceWords {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Usage java ReplaceWords *");
            System.exit(1);
        }
        ArrayList<File> files = new ArrayList<>();
        getFiles(files, args);
        try {
            replaceWords(files);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    
    public static void replaceWords(ArrayList<File> files) throws FileNotFoundException {
        for(int i = 0; i < files.size(); i++) {
            ArrayList<String> lines = new ArrayList<>();
            try(Scanner input = new Scanner(files.get(i));) {
                while(input.hasNext()) {
                    String line = input.nextLine();
                    if(line.contains("Exercise")) {
                        lines.add(pads(line));
                    }
                    else {
                        lines.add(line);
                    }
                }
            }
            try(PrintWriter output = new PrintWriter(files.get(i));) {
                for(int j = 0; j < lines.size(); j++) {
                    output.println(lines.get(j));
                }
            }
        }
    }
    
    public static String pads(String line) {
        ArrayList<String> word = new ArrayList<>(Arrays.asList(line.split(" ")));
        System.out.println(word.toString());
        for(int i = 0; i < word.size(); i++) {
            if(word.get(i).matches("Exercise\\d_\\d")) {
                StringBuilder str = new StringBuilder(word.get(i));
                str.insert(8, "0");
                str.insert(str.length() - 1, "0");
                word.remove(i);
                word.add(i, str.toString());
            }
//            if(word.get(i).matches("Exercise\\d{2}_\\d")) {
//                StringBuilder str = new StringBuilder(word.get(i));
//                str.insert(str.length() - 1, "0");
//                word.remove(i);
//                word.add(i, str.toString());
//            }
//            if(word.get(i).matches("Exercise\\d_\\d{2}")) {
//                StringBuilder str = new StringBuilder(word.get(i));
//                str.insert(8, "0");
//                word.remove(i);
//                word.add(i, str.toString());
//            }
        }
        String newLine = "";
        for(int i = 0; i < word.size(); i++) {
            newLine += word.get(i) + " ";
        }
        return newLine;
    }
    
    public static void getFiles(ArrayList<File> files, String[] args) {
        for(int i = 0; i < args.length; i++) {
            if(!args[i].equals("manifest.mf") && !args[i].equals("build.xml")) {
                files.add(new File(args[i]));
            }
        }
    }
}
