package renamefiles;

import java.io.File;
import java.util.ArrayList;

public class RenameFiles {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Usage java ReplaceWords *.*");
            System.exit(1);
        }
        ArrayList<File> files = new ArrayList<>();
        getFiles(files, args);
        for(File f : files) {
            renameFile(f);
        }
    }
    
    public static void renameFile(File file) {
        StringBuilder name = new StringBuilder(file.getName());
        name.insert(11, '0');
        file.renameTo(new File(name.toString()));
    }
    
    public static void getFiles(ArrayList<File> files, String[] args) {
        for(String a : args) {
            File file = new File(a);
            if(file.isFile() && file.getName().matches("Exercise\\d{2}_\\d.*")) {
                files.add(file);
            }
        }
    }
}
