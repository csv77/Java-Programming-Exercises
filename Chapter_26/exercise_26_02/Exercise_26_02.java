package exercise_26_02;

import exercise_25_10.BST;
import exercise_26_01.AVLTree;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise_26_02 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 500000; i++) {
            list.add((int)(Math.random() * 5000000));
        }
        
        BST<Integer> bst = new BST<>();
        AVLTree<Integer> avl = new AVLTree<>();
        
        Collections.shuffle(list);
        
        long startTime = System.currentTimeMillis();
        for(Integer i : list) {
            bst.insert(i);
        }
        System.out.println("Insert to BST (ms): " + (System.currentTimeMillis() - startTime));
        
        startTime = System.currentTimeMillis();
        for(Integer i : list) {
            avl.insert(i);
        }
        System.out.println("Insert to AVLTree (ms): " + (System.currentTimeMillis() - startTime));
        
        Collections.shuffle(list);
        
        startTime = System.currentTimeMillis();
        for(Integer i : list) {
            bst.search(i);
        }
        System.out.println("Search in BST (ms): " + (System.currentTimeMillis() - startTime));
        
        startTime = System.currentTimeMillis();
        for(Integer i : list) {
            avl.search(i);
        }
        System.out.println("Search in AVLTree (ms): " + (System.currentTimeMillis() - startTime));
        
        Collections.shuffle(list);
        
        startTime = System.currentTimeMillis();
        for(Integer i : list) {
            bst.delete(i);
        }
        System.out.println("Delete from BST (ms): " + (System.currentTimeMillis() - startTime));
        
        startTime = System.currentTimeMillis();
        for(Integer i : list) {
            avl.delete(i);
        }
        System.out.println("Delete from AVLTree (ms): " + (System.currentTimeMillis() - startTime));
    }
}
