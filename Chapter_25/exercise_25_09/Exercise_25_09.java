package exercise_25_09;

public class Exercise_25_09 {

    public static void main(String[] args) {
        Integer[] array1 = {60, 55, 100, 45, 57, 67, 107, 101, 109, 59};
        Integer[] array2 = {60, 55, 100, 45, 57, 67, 107, 101, 109, 10};
        BST<Integer> tree1 = new BST<>(array1);
        BST<Integer> tree1Clone = tree1.clone();
        BST<Integer> tree2 = new BST<>(array2);
        
        System.out.println("The tree1 with inorder traversal: ");
        for(Integer i : tree1) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n\nThe tree1Clone with inorder traversal: ");
        for(Integer i : tree1Clone) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n\nThe tree2 with inorder traversal: ");
        for(Integer i : tree2) {
            System.out.print(i + " ");
        }
                
        System.out.println("\n\nAre the two trees (tree1, tree1Clone) the same object? " + ((tree1 == tree1Clone) ? "Yes." : "No."));
        
        System.out.println("\nContain the two trees (tree1, tree1Clone) the same elements in the same structure? " + ((tree1.equals(tree1Clone)) ? "Yes." : "No."));
        
        System.out.println("\nAre the two trees (tree1, tree2) the same object? " + ((tree1 == tree2) ? "Yes." : "No."));
        
        System.out.println("\nContain the two trees (tree1, tree2) the same elements in the same structure? " + ((tree1.equals(tree2)) ? "Yes." : "No."));
    }
}
