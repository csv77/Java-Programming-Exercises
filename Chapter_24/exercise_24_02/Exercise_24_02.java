package exercise_24_02;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise_24_02 {

    public static void main(String[] args) {
        String[] array1 = {"Tom","Jane" , "Michael", "Jane", "Andrea"};
        MyLinkedList<String> list = new MyLinkedList<>(array1);
        
        System.out.println(list.contains("Tom"));
        System.out.println(list.contains("Juliette"));
        System.out.println(list.get(3));
        
        System.out.println(list.indexOf("Tom"));
        System.out.println(list.indexOf("Juliette"));
        System.out.println(list.indexOf("Andrea"));
        System.out.println(list.indexOf("Jane"));
        
        System.out.println(list.lastIndexOf("Jane"));
        System.out.println(list.set(0, "Patricia"));
        System.out.println(list);
    }
}
