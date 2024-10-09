
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 建立樹的節點
        tree.root = new TreeNode("a");
        tree.root.left = new TreeNode("b");
        tree.root.right = new TreeNode("c");
        tree.root.left.left = new TreeNode("d");
        tree.root.left.right = new TreeNode("e");

        // 遍歷
        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(tree.root);

        System.out.print("\nInorder traversal: ");
        tree.inorderTraversal(tree.root);

        System.out.print("\nPostorder traversal: ");
        tree.postorderTraversal(tree.root);
    }
}

