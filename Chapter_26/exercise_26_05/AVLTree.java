package exercise_26_05;

public class AVLTree<E extends Comparable<E>> extends BST<E> {
    /** Create an empty AVL tree */
    public AVLTree() {
    }

    /** Create an AVL tree from an array of objects */
    public AVLTree(E[] objects) {
        super(objects);
    }

    @Override /** Override createNewNode to create an AVLTreeNode */
    protected AVLTreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<E>(e);
    }
    
    public E find(int k) {
        if(k < 1 || k > this.size) {
            return null;
        }
        else {
            return find(k, (AVLTreeNode<E>)root);
        }
    }
        
    public E find(int k, AVLTreeNode<E> root) {
        AVLTreeNode<E> A = (AVLTreeNode<E>) root.left;
        AVLTreeNode<E> B = (AVLTreeNode<E>) root.right;
        
        if(A == null && k == 1) {
            return root.element;
        }
        else if(A == null && k == 2) {
            return B.element;
        }
        else if(k <= A.size) {
            return find(k, A);
        }
        else if(k == A.size + 1) {
            return root.element;
        }
        else {
            return find(k - A.size - 1, B);
        }
    }
    
    public int updateSize(AVLTreeNode<E> root) {
        if(root == null) {
            return 0;
        }
        else {
            root.size = 1 + updateSize((AVLTreeNode<E>)root.left) + updateSize((AVLTreeNode<E>)root.right);
        }
        return root.size;
    }

    @Override /** Insert an element and rebalance if necessary */
    public boolean insert(E e) {
        boolean successful = super.insert(e);
        if(!successful)
            return false; // e is already in the tree
        else {
            balancePath(e); // Balance from e to the root if necessary
            updateSize((AVLTreeNode<E>)root);
        }

        return true; // e is inserted
    }

    /** Update the height of a specified node */
    private void updateHeight(AVLTreeNode<E> node) {
        if(node.left == null && node.right == null) // node is a leaf
            node.height = 0;
        else if(node.left == null) // node has no left subtree
            node.height = 1 + ((AVLTreeNode<E>)(node.right)).height;
        else if(node.right == null) // node has no right subtree
            node.height = 1 + ((AVLTreeNode<E>)(node.left)).height;
        else
            node.height = 1 +
            Math.max(((AVLTreeNode<E>)(node.right)).height, ((AVLTreeNode<E>)(node.left)).height);
    }

    /** Balance the nodes in the path from the specified
     * node to the root if necessary
     */
    private void balancePath(E e) {
        java.util.ArrayList<BST.TreeNode<E>> path = path(e);
        for (int i = path.size() - 1; i >= 0; i--) {
            AVLTreeNode<E> A = (AVLTreeNode<E>)(path.get(i));
            updateHeight(A);
            
            switch (balanceFactor(A)) {
                case -2:
                    if(balanceFactor((AVLTreeNode<E>)A.left) <= 0) {
                        balanceLL(A); // Perform LL rotation
                    }
                    else {
                        balanceLR(A); // Perform LR rotation
                    }
                    break;
                case +2:
                    if(balanceFactor((AVLTreeNode<E>)A.right) >= 0) {
                        balanceRR(A); // Perform RR rotation
                    }
                    else {
                        balanceRL(A); // Perform RL rotation
                    }
            }
        }
    }

    /** Return the balance factor of the node */
    protected int balanceFactor(AVLTreeNode<E> node) {
        if (node.right == null) // node has no right subtree
            return -node.height;
        else if (node.left == null) // node has no left subtree
            return +node.height;
        else
            return ((AVLTreeNode<E>)node.right).height - ((AVLTreeNode<E>)node.left).height;
    }

    /** Balance LL (see Figure 26.3) */
    private void balanceLL(BST.TreeNode<E> A) {
        BST.TreeNode<E> B = A.left; // A is left-heavy and B is left-heavy
        BST.TreeNode<E> parentOfA = A.parent;
                
        if(A == root) {
            root = B;
        }
        else {
            if(parentOfA.left == A) {
                parentOfA.left = B;
            }
            else {
                parentOfA.right = B;
            }
        }
        
        A.parent = B;
        B.parent = parentOfA;
        if(B.right != null) {
            B.right.parent = A;
        }
        
        A.left = B.right; // Make T2 the left subtree of A
        B.right = A; // Make A the left child of B
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
    }

    /** Balance LR (see Figure 26.5) */
    private void balanceLR(BST.TreeNode<E> A) {
        BST.TreeNode<E> B = A.left; // A is left-heavy
        BST.TreeNode<E> C = B.right; // B is right-heavy
        BST.TreeNode<E> parentOfA = A.parent;
        
        if(A == root) {
            root = C;
        }
        else {
            if(parentOfA.left == A) {
                parentOfA.left = C;
            }
            else {
                parentOfA.right = C;
            }
        }

        A.parent = C;
        B.parent = C;
        C.parent = parentOfA;
        if(C.right != null) {
            C.right.parent = A;
        }
        if(C.left != null) {
            C.left.parent = B;
        }
        
        A.left = C.right; // Make T3 the left subtree of A
        B.right = C.left; // Make T2 the right subtree of B
        C.left = B;
        C.right = A;

        // Adjust heights
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    }

    /** Balance RR (see Figure 26.4) */
    private void balanceRR(BST.TreeNode<E> A) {
        BST.TreeNode<E> B = A.right; // A is right-heavy and B is right-heavy
        BST.TreeNode<E> parentOfA = A.parent;
        
        if(A == root) {
            root = B;
        }
        else {
            if(parentOfA.left == A) {
                parentOfA.left = B;
            }
            else {
                parentOfA.right = B;
            }
        }
        
        A.parent = B;
        B.parent = parentOfA;
        if(B.left != null) {
            B.left.parent = A;
        }
        
        A.right = B.left; // Make T2 the right subtree of A
        B.left = A;
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
    }

    /** Balance RL (see Figure 26.6) */
    private void balanceRL(BST.TreeNode<E> A) {
        BST.TreeNode<E> B = A.right; // A is right-heavy
        BST.TreeNode<E> C = B.left; // B is left-heavy
        BST.TreeNode<E> parentOfA = A.parent;
        
        if(A == root) {
            root = C;
        }
        else {
            if(parentOfA.left == A) {
                parentOfA.left = C;
            }
            else {
                parentOfA.right = C;
            }
        }
        
        A.parent = C;
        B.parent = C;
        C.parent = parentOfA;
        if(C.left != null) {
            C.left.parent = A;
        }
        if(C.right != null) {
            C.right.parent = B;
        }
        
        A.right = C.left; // Make T2 the right subtree of A
        B.left = C.right; // Make T3 the left subtree of B
        C.left = A;
        C.right = B;

        // Adjust heights
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    }

    @Override /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E element) {
        if(root == null)
            return false; // Element is not in the tree

        // Locate the node to be deleted and also locate its parent node
        BST.TreeNode<E> current = root;
        current.parent = null;
        while (current != null) {
            if(element.compareTo(current.element) < 0) {
                current.parent = current;
                current = current.left;
            }
            else if(element.compareTo(current.element) > 0) {
                current.parent = current;
                current = current.right;
            }
            else
                break; // Element is in the tree pointed by current
        }

        if(current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left children (See Figure 23.6)
        if(current.left == null) {
            // Connect the parent with the right child of the current node
            if(current.parent == null) {
                root = current.right;
            }
            else {
                if(element.compareTo(current.parent.element) < 0) {
                    current.parent.left = current.right;
                    current.right.parent = current.parent;
                }
                else {
                    current.parent.right = current.right;
                    current.right.parent = current.parent;
                }
                // Balance the tree if necessary
                balancePath(current.parent.element);
            }
        }
        else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            BST.TreeNode<E> rightMost = current.left;
            rightMost.parent = current;
            
            while(rightMost.right != null) {
                rightMost.parent = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if(rightMost.parent.right == rightMost) {
                rightMost.parent.right = rightMost.left;
                rightMost.left.parent = rightMost.parent;
            }
            else {
                // Special case: parentOfRightMost is current
                rightMost.parent.left = rightMost.left;
                rightMost.left.parent = rightMost.parent;
            }

            // Balance the tree if necessary
            balancePath(rightMost.parent.element);
        }
        
        updateSize((AVLTreeNode<E>)root);
        size--;
        return true; // Element inserted
    }

    /** AVLTreeNode is TreeNode plus height */
    protected static class AVLTreeNode<E extends Comparable<E>> extends BST.TreeNode<E> {
        protected int height = 0; // New data field
        protected int size = 0;
        
        public AVLTreeNode(E o) {
            super(o);
        }
    }
}
