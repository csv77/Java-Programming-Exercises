package createfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateFiles {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<File> directories = new ArrayList<>();
        addDirectories(directories);
        makeFiles(directories);
    }
    
    public static void makeFiles(ArrayList<File> dirs) throws FileNotFoundException{
        for(int i = 0; i < dirs.size(); i++){
            makeFiles(3, dirs.get(i), "TestJavaFile", ".java");
            makeFiles(3, dirs.get(i), "TestTextFile", ".txt");
            makeFiles(3, dirs.get(i), "TestDatFile", ".dat");
        }
        
    }
    
    public static void makeFiles(int n, File dir, String fileName, String ext) throws FileNotFoundException{
        for(int i = 1; i <= n; i++){
            File file = new File(dir, fileName + i + ext);
            if(!file.exists()){
                try(PrintWriter output = new PrintWriter(file);){
                    for(int j = 0; j < 100; j++){
                        output.print((int)(Math.random() * 500 + 1));
                        output.print(" ");
                    }
                }
            }
            else{
                System.out.println("File " + file.getName() + " is already exists!");
            }
        }
    }
    
    public static void addDirectories(ArrayList<File> list){
        for(int i = 1; i <= 34; i++){
            File dir = new File("srcRootDirectory/chapter" + i);
            if(!dir.isDirectory()){
                if(dir.mkdirs())
                    list.add(dir);
            }
        }
    }
}
