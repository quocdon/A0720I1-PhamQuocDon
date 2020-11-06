package exercises.optional_bst_postorder;

import java.util.prefs.NodeChangeEvent;

public class MyBinarySearchTree {
    class TreeNode {
        protected int data;
        protected TreeNode left;
        protected TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public MyBinarySearchTree() {
        root = null;
    }


    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        } else {
            if (data < root.data) {
                root.left = insertRecursive(root.left, data);
            } else if (data > root.data) {
                root.right = insertRecursive(root.right, data);
            }
        }
        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.data);
            inorderRecursive(root.right);
        }
    }

    public void postorder() {
        postorderRecursive(root);
    }

    private void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.println(root.data);
        }
    }

    public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public boolean search(int data) {
        TreeNode current = root;
        while (current != null) {
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else return true;
        }
        return false;
    }

//    public boolean delete(int data) {
//        if (!search(data)){
//            return false;
//        }
//    }
}
