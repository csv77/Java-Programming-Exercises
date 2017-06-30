package exercise_19_05;

public class Exercise_19_05 {

    public static void main(String[] args) {
        String[] strings = new String[4];
        strings[0] = "Australia";
        strings[1] = "Austria";
        strings[2] = "Argentina";
        strings[3] = "Andorra";
        
        System.out.println("The max element is: " + max(strings));
    }
    
    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for(int i = 1; i < list.length; i++) {
            if(max.compareTo(list[i]) < 0) {
                max = list[i];
            }
        }
        return max;
    }
}
