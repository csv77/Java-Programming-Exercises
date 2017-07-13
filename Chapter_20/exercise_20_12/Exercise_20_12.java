package exercise_20_12;

public class Exercise_20_12 {

    public static void main(String[] args) {
        MyPriorityQueue<String> queue1 = new MyPriorityQueue<>();
        queue1.offer("1");
        queue1.offer("2");
        queue1.offer("3");
        
        MyPriorityQueue<String> queue2 = new MyPriorityQueue<>();
        try {
            queue2 = (MyPriorityQueue<String>)queue1.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(queue1);
        System.out.println(queue2);
        
        queue1.remove("1");
        System.out.println(queue1);
        System.out.println(queue2);
    }
}
