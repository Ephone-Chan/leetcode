package datastructure.ds06_tree.L3_hard;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class P0145_binary_tree_postorder_traversal {


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;

        while (root != null || !stack.isEmpty()) {

            //一路向左边走
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode top = stack.peek();    //获取栈顶元素,要么是叶子,要么是中间结点

                if (top.right != null && top.right != last)  //若中间结点存在右子树,且未被访问,则进入右子树
                    root = top.right;
                else {
                    last = stack.pop(); //记录下来,倘若为某个右子树,再次遇到上面的 if 判断时会跳过,直接访问其父结点
                    result.add(top.val);   //访问
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {


        P0145_binary_tree_postorder_traversal postOrderTraversal = new P0145_binary_tree_postorder_traversal();

//   Tree
//            1
//               \
//                2
//              /
//            3

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        postOrderTraversal.postorderTraversal(root);
    }
}
