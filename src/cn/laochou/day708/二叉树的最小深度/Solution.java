package cn.laochou.day708.二叉树的最小深度;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/8 0008 12:02
 * @Version: 1.0
 */
public class Solution {

    public int minDepth(TreeNode root) {
        int min = getMinHeight(root);
        return min;
    }


    private int getMinHeight(TreeNode root) {
        if(root == null) return 0;
        int left = getMinHeight(root.left);
        int right = getMinHeight(root.right);
        if(left != 0 && right != 0) {
            return Math.min(left, right) + 1;
        }
        if(left == 0) {
            return right + 1;
        }
        if(right == 0) {
            return left + 1;
        }
        return 1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
