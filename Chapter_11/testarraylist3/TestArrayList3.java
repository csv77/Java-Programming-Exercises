package testarraylist3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestArrayList3 {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
                
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first list: ");
        fill(list1, input);
        System.out.println("Enter the second list: ");
        fill(list2, input);
        ArrayList<Integer> list3 = union(list1, list2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println("The combined list:");
        System.out.println(list3.toString());
        
        
//        System.out.println(list1.toString());
//        TestArrayList3.shuffle(list1);
//        System.out.println(list1.toString());
//        TestArrayList3.sort(list1);
//        System.out.println(list1.toString());
//        System.out.println("The sum is: " + TestArrayList3.sumList(list1));
//        TestArrayList3.removeDuplicate(list1);
//        System.out.println(list1.toString());
        
    }
    
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i = 0; i < list1.size(); i++){
            list3.add(list1.get(i));
        }
        for(int i = 0; i < list2.size(); i++){
            list3.add(list2.get(i));
        }
        return list3;
    }
    
    public static void fill(ArrayList<Integer> list, Scanner input){
        for(int i = 0; i < 5; i++){
            list.add(input.nextInt());
        }
    }
    
    public static void shuffle(ArrayList<Integer> list){
        Collections.shuffle(list);
    }
    
    public static void sort(ArrayList<Integer> list){
        Collections.sort(list);
    }
    
    public static int sumList(ArrayList<Integer> list){
        int sum = 0;
        for(Integer a : list){
            sum += a;
        }
        return sum;
    }
    
    public static void removeDuplicate(ArrayList<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i).intValue() == list.get(j).intValue()){
                    list.remove(j);
                }
            }
        }
    }
}
