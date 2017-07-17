package exercise_21_01;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Exercise_21_01 {

    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet(Arrays.asList("George",
                "Jim", "John", "Blake", "Kevin", "Michael"));
        LinkedHashSet<String> set2 = new LinkedHashSet(Arrays.asList("George",
                "Katie", "Kevin", "Michelle", "Ryan"));
        LinkedHashSet<String> setUnion = (LinkedHashSet<String>)set1.clone();
        LinkedHashSet<String> setDifference = (LinkedHashSet<String>)set1.clone();
        LinkedHashSet<String> setIntersection = (LinkedHashSet<String>)set1.clone();
        
        setUnion.addAll(set2);
        System.out.println("Union of set1 and set2: " + setUnion);       
        
        setDifference.removeAll(set2);
        System.out.println("Difference of set1 and set2: " + setDifference);
        
        setIntersection.retainAll(set2);
        System.out.println("Intersection of set1 and set2: " + setIntersection);
    }
}
