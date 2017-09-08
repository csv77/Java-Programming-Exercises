package exercise_27_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Exercise_27_11 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(18);
        set.add(3);
        set.add(12);
        
        ArrayList<Integer> list = setToList(set);
        
        System.out.println(list);
    }
    
    public static <E> ArrayList<E> setToList(Set<E> s) {
        ArrayList<E> list = new ArrayList<>();
        for(E e : s) {
            list.add(e);
        }
        
        return list;
    }
}
