package exercise_26_04;

public class Exercise_26_04 {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        for(int i = 1; i <= 10; i++) {
            tree.insert(i);
        }
        
        for(Integer i : tree) {
            if(tree.isLeaf(i)) {
                System.out.println(i + " is leaf.");
            }
        }
    }
}
