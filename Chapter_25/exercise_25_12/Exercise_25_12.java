package exercise_25_12;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercise_25_12 {

    public static void main(String[] args) {
        Integer[] array = {60, 55, 100, 45, 57, 67, 107, 101, 59};
        BST<Integer> tree = new BST<>(array);
        
        System.out.println("Could 120 be inserted? " + (tree.insert(120) ? "Yes." : "No"));
        System.out.println("Could 120 be inserted again? " + (tree.insert(120) ? "Yes." : "No"));
        
        System.out.println("Does the tree contain 60? " + (tree.search(60) ? "Yes." : "No."));
        System.out.println("Does the tree contain 61? " + (tree.search(61) ? "Yes." : "No."));
        
        System.out.println("\nTree with inorder traversal: ");
        for(Integer i : tree) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("Postorder traversal: ");
        tree.postorder();
        
        System.out.println("\nPreorder traversal: ");
        tree.preorder();
        
        System.out.println("\n\nTree size: " + tree.getSize());
        
        System.out.println("The root is: " + tree.getRoot().element);
        
        System.out.println("The path from the root to element 45: ");
        ArrayList<BST.TreeNode<Integer>> list = tree.path(45);
        for(BST.TreeNode<Integer> i : list) {
            System.out.print(i.element + " ");
        }
        System.out.println("\n");
        
        System.out.println("Could be deleted 60 from the tree? " + ((tree.delete(60) ? "Yes." : "No.")));
        System.out.println("Could be deleted 60 from the tree again? " + ((tree.delete(60) ? "Yes." : "No.")));
        
        System.out.println("The tree with inorder traversal now: ");
        tree.inorder();
        
        System.out.println("\n\nThe tree traversal using inorder iterator:");
        Iterator<Integer> iterator = tree.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        
        tree.clear();
        
        System.out.println("The root after clear() method was invoked: ");
        if(tree.getRoot() == null){
            System.out.println("The root is a nullpointer.");
        }
        else {
            System.out.println("The root isn't a nullpointer.");
        }
    }
}
