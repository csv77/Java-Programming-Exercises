package exercise_19_09;

import static exercise_19_08.Exercise_19_08.shuffle;
import java.util.ArrayList;

public class Exercise_19_09 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E min;
        int minIndex;
        
        for(int i = 0; i < list.size() - 1; i++) {
            min = list.get(i);
            minIndex = i;
            for(int j = i + 1; j < list.size(); j++) {
                if(min.compareTo(list.get(j)) > 0) {
                    minIndex = j;
                    min = list.get(j);
                }
            }
            if(minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
        }
    }
}
