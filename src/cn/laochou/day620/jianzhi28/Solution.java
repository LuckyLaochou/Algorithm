package cn.laochou.day620.jianzhi28;

public class Solution {

    /**
     * AC
     * 判断二叉树是否对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return recury(root.left, root.right);
    }


    private boolean recury(TreeNode left, TreeNode right) {
        // 必须两者都要同时为null，否则就是false
        if(left == null && right == null) {
            return true;
        }
        if(left == null) {
            return false;
        }
        if(right == null) {
            return false;
        }
        if(left.val == right.val) {
            return recury(left.left, right.right) && recury(left.right, right.left);
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {this.val = val;}
}
