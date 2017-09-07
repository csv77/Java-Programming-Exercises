package exercise_27_05;

public class Exercise_27_05 {

    public static void main(String[] args) {
        MyHashSet2<String> set1 = new MyHashSet2<>();
        set1.add("Smith");
        set1.add("Anderson");
        set1.add("Lewis");
        set1.add("Cook");
        set1.add("Smith");

        System.out.println("Elements in set: " + set1);
        System.out.println("Number of elements in set: " + set1.size());
        System.out.println("Is Smith in set? " + set1.contains("Smith"));

        set1.remove("Smith");
        System.out.print("Names in set in uppercase are ");
        for (String s: set1)
            System.out.print(s.toUpperCase() + " ");

        set1.clear();
        System.out.println("\nElements in set: " + set1);
        
        MyHashSet<String> set2 = new MyHashSet<>();
        set2.add("Smith");
        set2.add("Anderson");
        set2.add("Lewis");
        set2.add("Cook");
        set2.add("Smith");

        System.out.println("Elements in set: " + set2);
        System.out.println("Number of elements in set: " + set2.size());
        System.out.println("Is Smith in set? " + set2.contains("Smith"));

        set2.remove("Smith");
        System.out.print("Names in set in uppercase are ");
        for (String s: set2)
            System.out.print(s.toUpperCase() + " ");

        set2.clear();
        System.out.println("\nElements in set: " + set2);
    }
}
