package exercise_30_10;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise_30_10 {
    private static Set set = Collections.synchronizedSet(new HashSet());
    
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
                System.out.println("AddToSetThread");
                set.add(i);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) {
                }
            }
        }
    }
    
    public static class TraverseSetTask implements Runnable {

        @Override
        public void run() {
            while(true) {
                System.out.println("TraverseSetThread");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) {
                }
                synchronized(set) {
                    Iterator<Integer> iterator = set.iterator();
                    while(iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }        
            }
        }
    }
}
