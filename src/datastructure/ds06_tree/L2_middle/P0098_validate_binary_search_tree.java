package datastructure.ds06_tree.L2_middle;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P0098_validate_binary_search_tree {

    public static boolean isValidBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return true;

        return isValidCore(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static boolean isValidCore(TreeNode node, long min, long max) {

        if (node == null)
            return true;

        if (node.val > min && node.val < max
                && isValidCore(node.left, min, node.val)
                && isValidCore(node.right, node.val, max))
            return true;
        return false;

    }


    public static boolean isValidBSTinorder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();


        while(root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) >= list.get(i+1))
                return false;
        }

        return true;
    }




    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2147483648);

        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(2147483647);

//        root.left = left;
        root.right = right;

        System.out.println(isValidBSTinorder(root));
    }
}
