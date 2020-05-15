package datastructure.ds06_tree.L2_middle;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import util.TreeNode;

public class P0102_binary_tree_level_order_traversal {


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentLevel = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        int currentLevelCnt = 1;    //当前层的结点数量

        int currentLevelVisited = 0;    //当前层已访问的结点数量

        int nextLevelCnt = 0;   //下层结点数量


        if (root == null)
            return result;

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            currentLevel.add(node.val);

            currentLevelVisited++;

            if(node.left != null){
                nextLevelCnt++;
                queue.add(node.left);
            }

            if(node.right != null){
                nextLevelCnt++;
                queue.add(node.right);
            }

            if(currentLevelVisited == currentLevelCnt){

                result.add(currentLevel);

                currentLevel = new ArrayList<>();

                currentLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                currentLevelVisited = 0;
            }
        }

        return result;
    }

    public static void main(String[] args){


        TreeNode root = new TreeNode(3);

        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);

        root.left = l;
        root.right = r;

        l = new TreeNode(15);
        r = new TreeNode(7);
        root.right.left = l;
        root.right.right = r;


        System.out.println(levelOrder(root));


    }

}
