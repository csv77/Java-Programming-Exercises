package exercise_25_14;

import exercise_19_02.GenericStack;
import exercise_25_01.Tree;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BST<E> implements Tree<E>, Cloneable {
    protected TreeNode<E> root;
    protected int size = 0;
    protected Comparator<? super E> comparator;

    /** Create a default binary tree */
    public BST(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /** Create a binary tree from an array of objects */
    public BST(E[] objects, Comparator<? super E> comparator) {
        for(int i = 0; i < objects.length; i++)
            add(objects[i]);
        this.comparator = comparator;
    }

    @Override /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        while(current != null) {
            if(comparator.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if(comparator.compare(e, current.element) > 0) {
                current = current.right;
            }
            else // element matches current.element
                return true; // Element is found
        }

        return false;
    }

    @Override /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        if(root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while(current != null) 
                if(comparator.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if(comparator.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false; // Duplicate node not inserted
            
            // Create the new node and attach it to the parent node
            if(comparator.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    /** Inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override /** Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }

    /** Postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override /** Preorder traversal from the root */
    public void preorder() {
        preorder(root);
    }

    /** Preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
        if(root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /** This inner class is static, because it does not access 
        any instance members defined in its outer class */
    public static class TreeNode<E> {
        public E element;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /** Returns the root of the tree */
    public TreeNode<E> getRoot() {
        return root;
    }

    /** Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while(current != null) {
            list.add(current); // Add the node to the list
            if(comparator.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if(comparator.compare(e, current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

    @Override /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current != null) {
            if(comparator.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if(comparator.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break; // Element is in the tree pointed at by current
        }

        if(current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if(current.left == null) {
          // Connect the parent with the right child of the current node
            if(parent == null) {
                root = current.right;
            }
            else {
                if(comparator.compare(e, parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while(rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if(parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;     
        }

        size--;
        return true; // Element deleted successfully
    }
    
    /** Obtain an iterator. Use preorder. */
    public java.util.Iterator<E> preorderIterator() {
        return new PreorderIterator();
    }

    // Inner class InorderIterator
    private class PreorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list
        private java.util.ArrayList<E> list = new ArrayList<>();
        private int current = 0; // Point to the current element in list

        public PreorderIterator() {
            preorder(); // Traverse binary tree and store elements in list
        }

        /** Inorder traversal from the root*/
        private void preorder() {
            preorder(root);
        }

        /** Inorder traversal from a subtree */
        private void preorder(TreeNode<E> root) {
            if(root == null)return;
            list.add(root.element);
            preorder(root.left);
            preorder(root.right);
        }

        @Override /** More elements for traversing? */
        public boolean hasNext() {
            if(current < list.size())
                return true;

            return false;
        }

        @Override /** Get the current element and move to the next */
        public E next() {
            return list.get(current++);
        }

        @Override /** Remove the current element */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            preorder(); // Rebuild the list
        }
    }
    
        @Override /** Obtain an iterator. Use inorder. */
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /** Inorder traversal from the root*/
        private void inorder() {
            inorder(root);
        }

        /** Inorder traversal from a subtree */
        private void inorder(TreeNode<E> root) {
            if(root == null)return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override /** More elements for traversing? */
        public boolean hasNext() {
            if(current < list.size())
                return true;

            return false;
        }

        @Override /** Get the current element and move to the next */
        public E next() {
            return list.get(current++);
        }

        @Override /** Remove the current element */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }
    
    @Override /** Remove all elements from the tree */
    public void clear() {
        root = null;
        size = 0;
    }
    
    /** Displays the nodes in a breadth-first traversal */
    public void breadthFirstTraversal() {
        if(root == null) {
            return;
        }
        
        LinkedList<TreeNode<E>> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            TreeNode<E> current = list.element();
            if(current.left != null) {
                list.add(current.left);
            }
            if(current.right != null) {
                list.add(current.right);
            }
            System.out.print(list.remove().element + " ");
        }
        System.out.println();
    }
    
    /** Returns the height of this binary tree */
    public int height() {
        return height(root);
    }
    
    public int height(TreeNode<E> root) {
        if(root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    /** Returns true if the tree is a full binary tree */
    public boolean isFullBST() {
        return size == (int)(Math.pow(2, height() + 1) - 1);
    }
    
    /** Nonrecursive inorder traversal from the root */
    public void nonRecursiveInorder() {
        if(root == null) {
            return;
        }
        GenericStack<TreeNode<E>> stack = new GenericStack<>();
        TreeNode<E> current = root;
        while(!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode<E> node = stack.pop();
		System.out.print(node.element + " ");
		current = node.right;
            }
        }
        System.out.println();
    }
    
    /** Nonrecursive preorder traversal from the root */
    public void nonRecursivePreorder() {
        if(root == null) {
            return;
        }
        GenericStack<TreeNode<E>> stack = new GenericStack<>();
        TreeNode<E> current = root;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                System.out.print(current.element + " ");
                current = current.left;
            }
            else {
                TreeNode<E> node = stack.pop();
                current = node.right;
            }
        }
    }
    
    /** Nonrecursive postorder traversal from the root */
    public void nonRecursivePostorder() {
        if(root == null) {
            return;
        }
        GenericStack<TreeNode<E>> stack = new GenericStack<>();
        LinkedList<TreeNode<E>> list = new LinkedList<>();
        TreeNode<E> current = root;
        stack.push(current);
        while(!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();
            list.add(node);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        while(!list.isEmpty()) {
            System.out.print(list.removeLast().element + " ");
        }
        System.out.println();
    }
    
    /** Returns the number of leaf nodes */
    public int getNumberOfLeaves() {
        return getNumberOfLeaves(root, 0);
    }
    
    /** Returns the number of leaf nodes */
    public int getNumberOfLeaves(TreeNode<E> root, int number) {
        if(root == null) {
            return number;
        }
        else if(root.left == null && root.right == null){
            return ++number;
        }
        else {
            number = getNumberOfLeaves(root.left, number);
            number = getNumberOfLeaves(root.right, number);
            return number;
        }
    }
    
    /** Returns the number of nonleaf nodes */
    public int getNumberOfNonLeaves() {
        return getNumberOfNonLeaves(root, 0);
    }
    
    /** Returns the number of nonleaf nodes */
    public int getNumberOfNonLeaves(TreeNode<E> root, int number) {
        if(root == null) {
            return number;
        }
        else if(root.left == null && root.right == null) {
            return number;
        }
        else {
            number++;
            number = getNumberOfNonLeaves(root.left, number);
            number = getNumberOfNonLeaves(root.right, number);
            return number;
        }
    }
    
    @Override
    public BST<E> clone() {
        try {
            BST<E> treeClone = (BST)super.clone();
            copyTreeNodes(treeClone.root, root);
            return treeClone;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    public void copyTreeNodes(TreeNode<E> rootCopy, TreeNode<E> root) {
        if(root == null) {
            return;
        }
        else {
            rootCopy = new TreeNode(root.element);
            if(root.left != null) {
                copyTreeNodes(rootCopy.left, root.left);
            }
            if(root.right != null) {
                copyTreeNodes(rootCopy.right, root.right);
            }
        }
    }
    
    @Override
    public boolean equals(Object o) {
        BST<E> anotherTree = (BST<E>)o;
        if(anotherTree.getSize() != this.getSize()) {
            return false;
        }
        else {
            return equals(anotherTree.root, root);
        }
    }
    
    public boolean equals(TreeNode<E> rootCopy, TreeNode<E> root) {
        if(root == null && rootCopy == null) {
            return true;
        }
        else if((root == null && rootCopy != null) || (root != null && rootCopy == null)) {
            return false;
        }
        else {
            return equals(root.left, rootCopy.left) && equals(root.right, rootCopy.right);
        }
    }
    
    public List<E> inorderList() {
        List<E> listInorder = new ArrayList<>();
        inorderList(listInorder, root);
        return listInorder;
    }
    
    public void inorderList(List<E> listInorder, TreeNode<E> root) {
        if(root == null) {
            return;
        }
        inorderList(listInorder, root.left);
        listInorder.add(root.element);
        inorderList(listInorder, root.right);
    }
    
    public List<E> preorderList() {
        List<E> listPreorder = new ArrayList<>();
        preorderList(listPreorder, root);
        return listPreorder;
    }
    
    public void preorderList(List<E> listPreorder, TreeNode<E> root) {
        if(root == null) {
            return;
        }
        listPreorder.add(root.element);
        preorderList(listPreorder, root.left);
        preorderList(listPreorder, root.right);
    }
    
    public List<E> postorderList() {
        List<E> listPostorder = new ArrayList<>();
        postorderList(listPostorder, root);
        return listPostorder;
    }
    
    public void postorderList(List<E> listPostorder, TreeNode<E> root) {
        if(root == null) {
            return;
        }
        postorderList(listPostorder, root.left);
        postorderList(listPostorder, root.right);
        listPostorder.add(root.element);
    }
}