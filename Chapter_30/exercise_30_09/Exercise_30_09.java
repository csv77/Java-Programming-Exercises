package exercise_30_09;

import java.util.HashSet;
import java.util.Iterator;

public class Exercise_30_09 {
    private static HashSet<Integer> set = new HashSet<>();
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(new AddToSetTask());
        Thread thread2 = new Thread(new TraverseSetTask());
        thread1.start();
        thread2.start();
    }
    
    public static class AddToSetTask implements Runnable {

        @Override
        public void run() {
            for(int i = 0; i < 1000000; i++) {
                set.add(i);
            }
            try {
                    Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
            }
        }
    }
    
    public static class TraverseSetTask implements Runnable {

        @Override
        public void run() {
            try {
                while(true) {
                    Iterator<Integer> iterator = set.iterator();
                    while(iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex) {
            }
        }
    }
}
