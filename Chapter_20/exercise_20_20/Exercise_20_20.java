package exercise_20_20;

import java.io.File;
import java.util.Collections;
import java.util.Stack;

public class Exercise_20_20 {

    public static void main(String[] args) {
        File file = new File("c:/programming/java/Intro_to_Java_Programming_10th_exercises/JavaProgrammingExercises/Chapter_06/");
        System.out.println(file.getName() + " size: " + getSize(file) + " bytes");
    }
    
    public static long getSize(File directory) {
        long size = 0;
        Stack<File> stack = new Stack<>();
        stack.push(directory);
        while(!stack.isEmpty()) {
            directory = stack.pop();
            if(directory.isFile()) {
                size += directory.length();
            }
            else {
                File[] files = directory.listFiles();
                if(files != null) {
                    Collections.addAll(stack, files);
                }
            }
        }
        return size;
    }
}
