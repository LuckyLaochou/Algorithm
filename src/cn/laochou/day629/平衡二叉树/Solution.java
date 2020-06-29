package cn.laochou.day629.平衡二叉树;

import java.util.Map;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        // 我们通过判断所有左右子树的一个高度差
        return getHeight(root) != -1;
    }


    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if(left == -1) return -1;
        int right = getHeight(root.right);
        if(right == -1) return  -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
