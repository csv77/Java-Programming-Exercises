package exercise_24_01;

public class Exercise_24_01 {

    public static void main(String[] args) {
        String[] array1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] array2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
        MyArrayList<String> list1 = new MyArrayList<>(array1);
        MyArrayList<String> list2 = new MyArrayList<>(array2);
        
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1.addAll(list2);
        System.out.println("After list1.addAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1 = new MyArrayList<>(array1);
        list2 = new MyArrayList<>(array2);
        
        list1.removeAll(list2);
        System.out.println("After list1.removeAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
        
        list1 = new MyArrayList<>(array1);
        list2 = new MyArrayList<>(array2);
        
        list1.retainAll(list2);
        System.out.println("After list1.retainAll(list2)");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
    }
}
