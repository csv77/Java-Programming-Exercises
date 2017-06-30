package exercise_19_04;

public class Exercise_19_04 {

    public static void main(String[] args) {
        Integer[] integer = new Integer[10];
        
        for(int i = 0 ; i < integer.length; i++) {
            integer[i] = i * 4;
        }
        
        System.out.println(linearSearch(integer, 16));
        System.out.println(linearSearch(integer, 32));
        System.out.println(linearSearch(integer, 255));
    }
    
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for(int i = 0; i < list.length; i++) {
            if(list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
}
