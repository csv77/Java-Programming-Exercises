package exercise_19_08;

import java.util.ArrayList;

public class Exercise_19_08 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
    }
    
    public static <E> void shuffle(ArrayList<E> list) {
        for(int i = 0; i < list.size(); i++) {
            int index = (int)(Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
