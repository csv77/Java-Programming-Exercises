package exercise_26_01;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class AVLView extends Pane {
    private AVLTree<Integer> tree = new AVLTree<>();
    private double radius = 15;
    private double vGap = 50;

    AVLView(AVLTree<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear();
        if(tree.getRoot() != null) {
            displayTree((AVLTree.AVLTreeNode<Integer>)tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    private void displayTree(AVLTree.AVLTreeNode<Integer> root, double x, double y, double hGap) {
        if(root.left != null) {
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<Integer>)root.left, x - hGap, y + vGap, hGap / 2);
        }

        if(root.right != null) {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<Integer>)root.right, x + hGap, y + vGap, hGap / 2);
        }
        Text tBalanceFactor = new Text(x + 20, y + 4, tree.balanceFactor(root) + "");
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, root.element + ""), tBalanceFactor);
    }
}
