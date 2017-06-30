package exercise_19_03;

import java.util.ArrayList;

public class Exercise_19_03 {

    public static void main(String[] args) {
        ArrayList<String> string = new ArrayList<>();
        string.add("Berlin");
        string.add("Dresden");
        string.add("Berlin");
        string.add("Berlin");
        string.add("Dresden");
        string.add("Munchen");
        string = removeDuplicates2(string);
        System.out.println(string);
    }
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))) {
                    list.remove(j--);
                }
            }
        }
        return list;
    }
    
    public static <E> ArrayList<E> removeDuplicates2(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for(E element : list) {
            if(!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
