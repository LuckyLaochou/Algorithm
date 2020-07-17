package cn.laochou.字节常见笔试题.将有序数组转换成二叉搜索树;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 20:41
 * @Version: 1.0
 */
public class Solution {


    /**
     * 有序数组，转换成二叉树，而且两个子树的高度差不会超过一，我们可以通过递归来解决这个问题
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return recursion(nums, 0, nums.length - 1);
    }


    private TreeNode recursion(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, left, mid - 1);
        root.right = recursion(nums, mid + 1, right);
        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
