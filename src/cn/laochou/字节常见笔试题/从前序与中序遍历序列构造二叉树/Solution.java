package cn.laochou.字节常见笔试题.从前序与中序遍历序列构造二叉树;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 9:44
 * @Version: 1.0
 */
public class Solution {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode recursion(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if(pleft > pright || ileft > iright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pleft]);
        // 需要找到左子树的长度
        int index = findIndex(inorder, ileft, iright, preorder[pleft]);
        int length = index - ileft;
        root.left = recursion(preorder, pleft + 1, pleft + length, inorder, ileft, index - 1);
        root.right = recursion(preorder, pleft + length + 1, pright, inorder, index + 1, iright);
        return root;
    }



    private int findIndex(int[] inorder, int ileft, int iright, int target) {
        for(int i = ileft; i <= iright; i++) {
            if(inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
