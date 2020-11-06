package exercises.optional_bst_postorder;

public class mainBST {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(67);
        tree.insert(57);
        tree.insert(107);
        tree.insert(59);
        tree.insert(101);
        System.out.println("InOrder");
        tree.inorder();
        System.out.println("PostOrder");
        tree.postorder();
        System.out.println("PreOrder");
        tree.preorder();
        System.out.println(tree.search(54));
    }
}
