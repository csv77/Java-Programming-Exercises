package exercise_24_03;

import java.util.ListIterator;

public class Exercise_24_03 {

    public static void main(String[] args) {
        String[] array1 = {"Tom","Jane" , "Michael", "Jane", "Andrea"};
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>(array1);
        System.out.println(list);
        
        list.addFirst("Sarah");
        System.out.println(list);
        
        list.addLast("Patrick");
        System.out.println(list);
        
        list.add(3, "John");
        System.out.println(list);
        
        ListIterator<String> iterator = list.listIterator(0);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(iterator.next());
        }
        
        iterator = list.listIterator(list.size() - 1);
        for(int i = list.size() - 1; iterator.hasPrevious() && i >= 0; i--) {
            System.out.println(iterator.previous());
        }
        
        list.removeFirst();
        System.out.println(list);
        
        list.removeLast();
        System.out.println(list);
                
    }
}
