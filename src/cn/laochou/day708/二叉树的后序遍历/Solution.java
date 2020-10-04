package cn.laochou.day708.二叉树的后序遍历;

import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/8 0008 10:31
 * @Version: 1.0
 */
public class Solution {


    public void afterOrderNonRecursion(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node);
            if(node.left != null) {
                stack.add(node.left);
            }
            if(node.right != null) {
                stack.add(node.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop().val + " ");
        }
    }


    public void midOrderNonRecursion(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        solution.afterOrderNonRecursion(root);
        solution.midOrderNonRecursion(root);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
}
