package exercise_30_11;

public class Exercise_30_11 {
    
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        Thread thread1 = new Thread(new Task(object1, object2, 1));
        Thread thread2 = new Thread(new Task(object2, object1, 2));
        thread1.start();
        thread2.start();
    }
    
    public static class Task implements Runnable {
        public Object object1;
        public Object object2;
        public int taskIndex;

        public Task(Object object1, Object object2, int taskIndex) {
            this.object1 = object1;
            this.object2 = object2;
            this.taskIndex = taskIndex;
        }
        
        @Override
        public void run() {
            System.out.println("Task" + taskIndex + " is running.");
            while(true) {
                synchronized(object1) {
                    System.out.println("Task" + taskIndex + " locked object1.");
                    synchronized(object2) {
                        System.out.println("Task" + taskIndex + " locked object2.");
                    }
                }
            }
        }
    }
}
