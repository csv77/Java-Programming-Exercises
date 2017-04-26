package teststopwatch;

public class TestStopWatch {

    public static void main(String[] args) {
        StopWatch stopper = new StopWatch();
        int[] array = initArray();
        stopper.start();
        selectionSort(array);
        stopper.stop();
        System.out.println("Elapsed time is: " + stopper.getElapsedTime() + " ms");
    }
    
    public static int[] initArray(){
        int[] array = new int[100000];
        for(int i = 0; i < 100000; i++){
            array[i] = (int)(Math.random() * 100000);
        }
        return array;
    }
    
    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int min = array[i];
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
    
}
