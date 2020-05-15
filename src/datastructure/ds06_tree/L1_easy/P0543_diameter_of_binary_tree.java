package datastructure.ds06_tree.L1_easy;

import util.TreeNode;

public class P0543_diameter_of_binary_tree {

    static int res = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        if(root == null)
            return 0;

        depth(root);

        return res;
    }

    public static int depth(TreeNode node){

        if(node == null)
            return 0;

        int leftChild = depth(node.left);

        int rightChild = depth(node.right);

        res = Math.max(res , leftChild + rightChild);

        return Math.max(leftChild, rightChild)+1;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        root.left = left;

        TreeNode right = new TreeNode(3);
        root.right = right;

        System.out.println(diameterOfBinaryTree(root));

    }

}
