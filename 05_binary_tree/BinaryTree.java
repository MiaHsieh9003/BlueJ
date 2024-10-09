class BinaryTree {
    TreeNode root;

    // Preorder Traversal: 根 -> 左 -> 右
    void preorderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // Inorder Traversal: 左 -> 根 -> 右
    void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    // Postorder Traversal: 左 -> 右 -> 根
    void postorderTraversal(TreeNode node) {    //4
        if (node == null) return;
        postorderTraversal(node.left);  //2
        postorderTraversal(node.right); //6
        System.out.print(node.value + " "); 
    }
}
