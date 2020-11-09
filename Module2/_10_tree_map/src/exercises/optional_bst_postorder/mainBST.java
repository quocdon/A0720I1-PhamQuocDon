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
        System.out.println();
        System.out.println("PostOrder");
        tree.postorder();
        System.out.println();
        System.out.println("PreOrder");
        tree.preorder();
        System.out.println();
        System.out.println(tree.search(54));
        MyBinarySearchTree tree2 = new MyBinarySearchTree();
        tree2.insert(20);
        tree2.insert(40);
        tree2.insert(10);
        tree2.insert(16);
        tree2.insert(30);
        tree2.insert(80);
        tree2.insert(14);
        tree2.insert(50);
        tree2.delete(20);
        tree2.preorder();
        System.out.println();
        tree2.delete(80);
        tree2.preorder();
        System.out.println();
        tree2.delete(40);
        tree2.preorder();
    }
}
