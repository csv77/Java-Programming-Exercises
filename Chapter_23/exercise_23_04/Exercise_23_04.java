package exercise_23_04;

public class Exercise_23_04 {

    public static void main(String[] args) {
        int[] numbers = {5, 5, -7, 0, -100, -30, 50, 25, 25, 0, -100};
        quickSort(numbers);
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
    
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }
    
    public static void quickSort(int[] list, int first, int last) {
        if(last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    
    public static int partition(int[] list, int first, int last) {
        int middle = (last + first) / 2;
        int pivotIndex = first;
        switch(median(list[first], list[middle], list[last])) {
            case 0 :
                pivotIndex = first;
                break;
            case 1 : 
                pivotIndex = middle;
                break;
            case 2 : 
                pivotIndex = last;
        } 
        int pivot = list[pivotIndex];
        int low = first;
        int high = last;
        
        while(high > low) {
            while(low <= high && list[low] <= pivot) {
                low++;
            }
            
            while(low <= high && list[high] > pivot) {
                high--;
            }
            
            if(high > low) {
                if(high == pivotIndex) {
                    pivotIndex = low;
                }
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        
        while(high > first && list[high] > pivot) {
            high--;
        }
        
        if(pivot >= list[high]) {
            list[pivotIndex] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return pivotIndex;
        }
    }
    
    public static int median(int first, int middle, int last) {
        if(first > middle) {
            if(middle > last) {
                return 1;
            }
            else if(first > last) {
                return 2;
            }
            else {
                return 0;
            }
        }
        else {
            if(first > last) {
                return 0;
            }
            else if(middle > last) {
                return 2;
            }
            else {
                return 1;
            }
        }
    }
}
