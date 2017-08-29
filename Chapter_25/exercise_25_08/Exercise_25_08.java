package exercise_25_08;

import java.util.ListIterator;

public class Exercise_25_08 {

    public static void main(String[] args) {
        Integer[] array = {60, 55, 100, 45, 57, 67, 107, 101, 109, 59};
        BST<Integer> tree = new BST<>(array);
        System.out.println("Inorder traversal: ");
        tree.inorder();
        
        System.out.println("\nInorder traversal with for loop: ");
        for(Integer i : tree) {
            System.out.print(i + " ");
        }
        System.out.println("\nBackward inorder traversal with iterator: ");
        
        ListIterator<Integer> backwardIterator = tree.iterator(tree.getSize());
        while(backwardIterator.hasPrevious()) {
            System.out.print(backwardIterator.previous() + " ");
        }
        System.out.println();
    }
}
