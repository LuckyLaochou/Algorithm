package cn.laochou.字节常见笔试题.二叉树中的最大路径和;


/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 20:03
 * @Version: 1.0
 */
public class Solution {

    private int res = 0;

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        // 使用回溯来搞
        recursion(root);
        return res;
    }


    private int recursion(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = Math.max(recursion(root.left), 0);
        int right = Math.max(recursion(root.right), 0);
        res = Math.max(res, root.val + left + right);
        // 这里注意，因为如果返回上一个节点的话，只能取一边的值。
        return Math.max(left, right) + root.val;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
