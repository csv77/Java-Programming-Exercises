package exercise_24_15;

import exercise_24_01.MyArrayList;
import java.util.Iterator;

public class Exercise_24_15 {

    public static void main(String[] args) {
        String[] array1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] array2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
        MyArrayList<String> list1 = new MyArrayList<>(array1);
        MyArrayList<String> list2 = new MyArrayList<>(array2);
        
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        System.out.println("Capacity of list1: " + list1.getCapacity() + "\n");
        
        try {
            list1.add(3, "Emily");
            System.out.println("list1 after inserting Emily in the 3rd index:" + list1);
            list1.add(15, "Robert");
            System.out.println("This message won't appear on console.");
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("Index is out of range.");
        }
        
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
        System.out.println("The index of Robert in list1 is: " + list1.indexOf("Robert"));
        System.out.println();
        
        list1.add(4, "Tom");
        System.out.println("list1: " + list1);
        System.out.println("The last index of Tom in list1 is: " + list1.lastIndexOf("Tom"));
        System.out.println("The last index of Robert in list1 is: " + list1.lastIndexOf("Robert"));
        System.out.println();
        
        try {
            System.out.println("Removing the 4th element: " + list1.remove(4));
            System.out.println("List1 after removing the 4th element: " + list1);
            list1.remove(20);
            System.out.println("This message won't appear on console.");
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("Index is out of range.");
            System.out.println("List1 is unchanged: " + list1 + "\n");
        }
        
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
        
        System.out.println("Capacity before trim to size: " + list1.getCapacity() + ", the size is " + list1.size());
        list1.trimToSize();
        System.out.println("Capacity after trim to size: " + list1.getCapacity() + "\n");
        
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
        
        list1 = new MyArrayList<>(array1);
        list2 = new MyArrayList<>(array2);
        
        list1.removeAll(list2);
        System.out.println("List1 reseted to default. After list1.removeAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1 = new MyArrayList<>(array1);
        list2 = new MyArrayList<>(array2);
        
        list1.retainAll(list2);
        System.out.println("List1 reseted to default. After list1.retainAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1.clear();
        System.out.println("List1 after clear(): " + list1);
    }
}
