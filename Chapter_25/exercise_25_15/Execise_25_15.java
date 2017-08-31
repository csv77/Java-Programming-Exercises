package exercise_25_15;

import java.util.ArrayList;

public class Execise_25_15 {

    public static void main(String[] args) {
        BST<String> tree = new BST<String>();
        tree.insert("Michael");
        tree.insert("Adam");
        tree.insert("Michelle");
        tree.insert("Susan");
        
        tree.inorder();
        tree.delete("Michelle");
        
        System.out.println();
        tree.inorder();
        System.out.println();
        
        tree.insert("Simon");
        
        tree.inorder();
        System.out.println();
        
        System.out.println(tree.getNode("Michael").element);
        
    }
}
