package cn.laochou.day623.重建二叉树;

/**
 * 重建二叉树
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder
     * @param pLeft
     * @param pRight
     * @param inorder
     * @param iLeft
     * @param iRight
     * @return
     */
    private TreeNode build(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if(pLeft > pRight || iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        // 我们需要找到切分的index
        int index = findIndex(preorder[pLeft], inorder, iLeft, iRight);
        int leftLen = index - iLeft;
        root.left = build(preorder, pLeft + 1, pLeft + leftLen, inorder, iLeft, index - 1);
        root.right = build(preorder, pLeft + leftLen + 1, pRight, inorder, index + 1, iRight);
        return root;
    }


    private int findIndex(int base, int[] inorder, int iLeft, int iRight) {
        for(int i = iLeft; i <= iRight; i++) {
            if(inorder[i] == base) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
