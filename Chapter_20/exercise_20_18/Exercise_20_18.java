package exercise_20_18;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

public class Exercise_20_18 {

    public static void main(String[] args) {
        File file = new File("c:/programming/java/Intro_to_Java_Programming_10th_exercises/JavaProgrammingExercises/Chapter_06/");
        System.out.println(file.getName() + " has " + getSize(file) + " bytes");
    }
    
    public static long getSize(File directory) {
        long size = 0;
        LinkedList<File> queue = new LinkedList<>();
        queue.offer(directory);
        while(!queue.isEmpty()) {
            directory = queue.poll();
            if(directory.isFile()) {
                size += directory.length();
            }
            else {
                File[] files = directory.listFiles();
                if(files != null) {
                    Collections.addAll(queue, files);
                }
            }
        }
        return size;
    }
}