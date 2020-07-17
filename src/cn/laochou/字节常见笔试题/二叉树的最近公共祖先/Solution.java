package cn.laochou.字节常见笔试题.二叉树的最近公共祖先;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 20:54
 * @Version: 1.0
 */
public class Solution {


    /**
     * 从左边找一找，从右边找一找。就行了
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
