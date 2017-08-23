package exercise_24_03;

import java.util.ListIterator;

public class Exercise_24_03 {

    public static void main(String[] args) {
        String[] array1 = {"Tom","Marion" , "Michael", "Jane", "Andrea"};
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>(array1);
        System.out.println(list);
        
        list.addFirst("Sarah");
        System.out.println(list);
        
        list.addLast("Patrick");
        System.out.println(list);
        
        list.add(3, "John");
        System.out.println(list + "\n");
        
        list.add(6, "Julia");
        System.out.println(list + "\n");
                
        ListIterator<String> iterator = list.listIterator(0);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        
        iterator = list.listIterator(5);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        
        iterator = list.listIterator(4);
        while(iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println("\n");
        
        list.removeFirst();
        System.out.println(list);
        
        list.removeLast();
        System.out.println(list);
        
        list.remove(2);
        System.out.println(list);
        
        list.remove(4);
        System.out.println(list);
        
        System.out.println(list.contains("Jane"));
        System.out.println(list.contains("James"));
               
        System.out.println(list.get(1));
        System.out.println(list.get(4));
        
        System.out.println(list.indexOf("Michael"));
        System.out.println(list.indexOf("Tom"));
        System.out.println(list.indexOf("Andrea"));
        System.out.println(list.indexOf("James"));
        
        list.add(2, "Andrea");
        System.out.println(list);
        
        System.out.println(list.lastIndexOf("Andrea"));
        System.out.println(list.lastIndexOf("Marion"));
        System.out.println(list.lastIndexOf("James"));
        
        System.out.println(list.set(5, "Andrew"));
        System.out.println(list);
        
        iterator = list.listIterator(0);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        
        iterator = list.listIterator(list.size() - 1);
        while(iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println("\n");
    }
}
