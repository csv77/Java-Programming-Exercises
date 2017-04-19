package shufflearraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleArrayList {

    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        shuffle(list);
        System.out.println(list.toString());
        sort(list);
        System.out.println(list.toString());
    }
    
    public static void shuffle(ArrayList<Number> list) {
        Collections.shuffle(list);
    }
    
    public static void sort(ArrayList<Number> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            Number min = list.get(i);
            int minIndex = i;
            for(int j = i + 1; j < list.size(); j++) {
                if(min.doubleValue() > list.get(j).doubleValue()) {
                    min = list.get(j);
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
            
        }
    }
}
