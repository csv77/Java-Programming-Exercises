package exercise_25_10;

import java.util.Iterator;

public class Exercise_25_10 {

    public static void main(String[] args) {
        Integer[] array = {60, 55, 100, 45, 57, 67, 107, 101, 59};
        BST<Integer> tree = new BST<>(array);
        
        Iterator<Integer> inorderIterator = tree.iterator();
        Iterator<Integer> preorderIterator = tree.preorderIterator();
        
        System.out.println("Traversal with inorder iterator:");
        while(inorderIterator.hasNext()) {
            System.out.print(inorderIterator.next() + " ");
        }
        
        System.out.println("\n\nTraversal with preorder iterator: ");
        while(preorderIterator.hasNext()) {
            System.out.print(preorderIterator.next() + " ");
        }
        System.out.println();
    }
}
