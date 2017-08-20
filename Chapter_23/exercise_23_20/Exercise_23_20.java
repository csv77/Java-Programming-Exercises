package exercise_23_20;

public class Exercise_23_20 {

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    
    public static void mergeSort(int[] list) {
        mergeSort(list, 0, list.length - 1);
    }
    
    public static void mergeSort(int[] list, int first, int last) {
        if(last + 1 - first > 1) {
            int half = (first + last) / 2;
            mergeSort(list, first, half);
            mergeSort(list, half + 1, last);
            
            merge(list, first, half, last);
        }
    }
    
    public static void merge(int[] list, int first, int half, int last) {
        int[] temp = new int[last - first + 1];
        int current1 = first;
        int current2 = half + 1;
        int current3 = 0;
        
        while(current1 <= half && current2 <= last) {
            if(list[current1] < list[current2]) {
                temp[current3++] = list[current1++];
            }
            else {
                temp[current3++] = list[current2++];
            }
        }
        
        while(current1 <= half) {
            temp[current3++] = list[current1++];
        }
        
        while(current2 <= last) {
            temp[current3++] = list[current2++];
        }
        
        for(int i = first, j = 0; i <= last && j < temp.length; i++, j++) {
            list[i] = temp[j];
        }
    }
}
