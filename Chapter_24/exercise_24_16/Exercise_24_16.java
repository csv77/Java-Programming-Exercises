package exercise_24_16;

import exercise_24_02.MyLinkedList;
import java.util.Iterator;

public class Exercise_24_16 {

    public static void main(String[] args) {
        String[] array1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] array2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
        MyLinkedList<String> list1 = new MyLinkedList<>(array1);
        MyLinkedList<String> list2 = new MyLinkedList<>(array2);
        
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1.add(3, "Emily");
        System.out.println("list1 after inserting Emily in the 3rd index:" + list1);
        list1.add(15, "Robert");
        System.out.println("list1 after inserting Robert in the 15th index, which means it was added to the end:" + list1);
        
        System.out.println("Is the name Robert in the list? " + (list1.contains("Robert") ? "Yes." : "No."));
        System.out.println("Is the name Emily in the list? " + (list1.contains("Emily") ? "Yes.\n" : "No.\n"));
        
        try {
            System.out.println("Getting 5th index: " + list1.get(5));
            System.out.println("Getting 10th index: " + list1.get(10));
            System.out.println("This message won't appear on console.");
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("Index is out of range.\n");
        }
        
        System.out.println("The index of Emily in list1 is: " + list1.indexOf("Emily"));
        System.out.println("The index of Francis in list1 is: " + list1.indexOf("Francis"));
        System.out.println();
        
        list1.add(4, "Tom");
        System.out.println("list1: " + list1);
        System.out.println("The last index of Tom in list1 is: " + list1.lastIndexOf("Tom"));
        System.out.println("The last index of Francis in list1 is: " + list1.lastIndexOf("Francis"));
        System.out.println();
        
        System.out.println("Removing the 4th element: " + list1.remove(4));
        System.out.println("List1 after removing the 4th element: " + list1 + "\n");
        
        list1.remove(20);
        System.out.println("Removing the 20th element: " + list1.remove(20));
        System.out.println("List1 after removing the 20th element is unchanged: " + list1 + "\n");
        
        try {
            System.out.println("Set the name June on 2nd place. The old name there was " + list1.set(2, "June"));
            System.out.println("List1 after setting June on the 2nd index: " + list1);
            list1.set(20, "Robert");
            System.out.println("This message won't appear on console.");
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("Index is out of range.");
            System.out.println("List1 is unchanged: " + list1 + "\n");
        }
        
        System.out.println("List1 names with iterator:");
        Iterator<String> iterator = list1.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        for(String name : list1) {
            System.out.print(name + " ");
        }
        System.out.println("\n");
        
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1.addAll(list2);
        System.out.println("After list1.addAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1 = new MyLinkedList<>(array1);
        list2 = new MyLinkedList<>(array2);
        
        list1.removeAll(list2);
        System.out.println("List1 reseted to default. After list1.removeAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1 = new MyLinkedList<>(array1);
        list2 = new MyLinkedList<>(array2);
        
        list1.retainAll(list2);
        System.out.println("List1 reseted to default. After list1.retainAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1 = new MyLinkedList<>(array1);
        System.out.println("List1 reseted to default: " + list1);
        
        list1.addFirst("John");
        list1.addLast("Mary");
        System.out.println("List1 after John was added to the first and Mary was added to the last place:\n" + list1 + "\n");
        
        System.out.println("The first element is now: " + list1.getFirst());
        System.out.println("The last element is now: " + list1.getLast() + "\n");
        
        System.out.println("Removing the first name: " + list1.removeFirst());
        System.out.println("List1 now: " + list1);
        System.out.println("Removing the last name: " + list1.removeLast());
        System.out.println("List1 now: " + list1 + "\n");
        
        list1.clear();
        System.out.println("List1 after clear(): " + list1 + "\n");
    }
}
