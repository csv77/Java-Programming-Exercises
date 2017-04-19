package addpackagestatement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddPackageStatement {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 1){
            System.out.println("The usage: java AddPackageStatement srcRootDirectory");
            System.exit(1);
        }
        
        File root = new File(args[0]);
        if(!root.exists()){
            System.out.println("The " + args[0] + " does not exists!");
            System.exit(2);
        }
        
        ArrayList<File> dirs = new ArrayList<>();
        getDirectories(dirs, root);
        
        while(!dirs.isEmpty()){
            ArrayList<File> files = getFiles(dirs);
            //removeStatement(files, dirs.get(0));
            insertStatement(files, dirs.get(0));
            dirs.remove(0);
        }
    }
    
    public static void removeStatement(ArrayList<File> files, File dir) throws FileNotFoundException{
        for(int i = 0; i < files.size(); i++){
            ArrayList<String> lines = new ArrayList<>();
            try(Scanner input = new Scanner(files.get(i));){
                while(input.hasNext()){    
                    lines.add(input.nextLine());
                }
            }
            try(PrintWriter output = new PrintWriter(files.get(i));){
                for(int j = 1; j < lines.size(); j++){
                    output.println(lines.get(j));
                }
            }
        }
    }
    
    public static void insertStatement(ArrayList<File> files, File dir) throws FileNotFoundException{
        for(int i = 0; i < files.size(); i++){
            ArrayList<String> lines = new ArrayList<>();
            lines.add("package " + dir.getName() + ";");
            try(Scanner input = new Scanner(files.get(i));){
                while(input.hasNext()) {
                    lines.add(input.nextLine());
                }
            }
            try(PrintWriter output = new PrintWriter(files.get(i));){
                for(int j = 0; j < lines.size(); j++){
                    output.println(lines.get(j));
                }
            }
        }
    }
    
    public static ArrayList<File> getFiles(ArrayList<File> dirs){
        if(!dirs.get(0).exists()){
            System.out.println("The directory " + dirs.get(0).getName() + " does not exists.");
            System.exit(3);
        }
        ArrayList<File> files = new ArrayList<>(Arrays.asList(dirs.get(0).listFiles()));
        ArrayList<File> javaFiles = new ArrayList<>();
        javaFilter(files, javaFiles);
        return javaFiles;
    }
    
    public static void javaFilter(ArrayList<File> files, ArrayList<File> javaFiles){
        for(int i = 0; i < files.size(); i++){
            String name = files.get(i).getName();
            boolean isjavaCode = name.substring(name.lastIndexOf(".")).equals(".java");
            if(isjavaCode){
                javaFiles.add(files.get(i));
            }
        }
    }
    
    public static void getDirectories(ArrayList<File> dirs, File root){
        for(int i = 1; i <= 34; i++){
            File dir = new File(root, "chapter" + i);
            dirs.add(dir);
        }
    }
}
