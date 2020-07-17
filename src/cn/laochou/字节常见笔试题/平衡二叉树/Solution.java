package cn.laochou.字节常见笔试题.平衡二叉树;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 20:45
 * @Version: 1.0
 */
public class Solution {


    /**
     * 怎么判断二叉树是否是平衡二叉树呢
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return getHeight(root) != -1;
    }


    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left == -1 || right == -1 ||Math.abs(left - right) > 1) {
            return -1;
        }
        return left > right ? 1 + left : 1 + right;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}