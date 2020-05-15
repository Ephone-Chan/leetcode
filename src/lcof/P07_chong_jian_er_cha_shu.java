package lcof;

import util.TreeNode;

public class P07_chong_jian_er_cha_shu {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode build(
            int preorder_start, int preorder_end,
            int inorder_start, int inorder_end,
            int[] preorder,
            int[] inorder) {

        //无叶子节点
        if(preorder_start > preorder_end)
            return null;

        //只有一个节点，叶子节点
        if (preorder_start == preorder_end) {
            return new TreeNode(preorder[preorder_start]);
        }

        //从先序数组中取根节点
        int root = preorder[preorder_start];

        //从中序数组 找 左右子树的范围
        int leftCount = 0;
        for (int i = inorder_start; i <= inorder_end; i++) {
            if (inorder[i] == root)
                break;
            leftCount++;
        }

        int rightCount = inorder_end - inorder_start - leftCount - 1 + 1;

        //左子树
        // 前序
        // preorder_start + 1 : 跳过根节点，左子树的开始
        // preorder_start + leftCount : 左子树的边界
        // 中序
        // inorder_start : 左子树的开始
        // inorder_start + leftCount -1 : 左子树的边界，根节点之前
        TreeNode left = build(preorder_start + 1, preorder_start + leftCount, inorder_start, inorder_start + leftCount-1, preorder, inorder);

        //右子树
        //前序
        // preorder_start + leftCount + 1：跳过根节点，再跳过左子树，右子树的开始
        // preorder_end：右子树的边界
        //中序
        // inorder_start + leftCount + 1：跳过左子树，再跳过根节点，右子树开始
        // inorder_end：右子树边界
        TreeNode right = build(preorder_start + leftCount + 1 , preorder_end, inorder_start + leftCount + 1, inorder_end, preorder, inorder);

        //创建根节点
        TreeNode res = new TreeNode(root);
        res.left = left;
        res.right = right;

        return res;
    }

    public static void main(String[] args) {


//        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//
//        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        int[] pre = {};
        int[] in = {};


        TreeNode res = buildTree(pre, in);

        System.out.println(res);


    }

}
