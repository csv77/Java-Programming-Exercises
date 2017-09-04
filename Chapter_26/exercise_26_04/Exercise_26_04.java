package exercise_26_04;

public class Exercise_26_04 {

    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<String>();
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
        
        System.out.println(tree.getPath("Simon"));
        System.out.println(tree.getPath("Adam"));
    }
}
