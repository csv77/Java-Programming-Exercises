package exercise_25_15;

import java.util.ArrayList;

public class Exercise_25_15 {

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
        BST.TreeNode<String> name = tree.getNode("Michaela");
        if(name != null){
            System.out.println(name.element);
        }
        else {
            System.out.println("The tree doesn't contain this element.");
        }
        
        System.out.println("Is Michael leaf? " + ((tree.isLeaf("Michael")) ? "Yes." : "No."));
        System.out.println("Is Adam leaf? " + ((tree.isLeaf("Adam")) ? "Yes." : "No."));
        System.out.println("Is Susan leaf? " + ((tree.isLeaf("Susan")) ? "Yes." : "No."));
        System.out.println("Is Simon leaf? " + ((tree.isLeaf("Simon")) ? "Yes." : "No."));
        System.out.println("Is Julia leaf? " + ((tree.isLeaf("Julia")) ? "Yes." : "No."));
        
        tree.add("Nora");
        tree.add("Zachary");
        tree.add("William");
        
        ArrayList<String> list = tree.getPath("Simon");
        System.out.println(list);
        
        list = tree.getPath("William");
        System.out.println(list);
        
        list = tree.getPath("Julia");
        System.out.println(list);
    }
}
