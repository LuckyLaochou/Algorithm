package cn.laochou.day625.二叉树;

import java.util.Stack;

/**
 * 二叉树的一些点
 */
public class BinaryTree {

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 非递归版本前序遍历
    public void preOrderNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                System.out.println(root.val);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // 非递归版本中序遍历
    public void inOrderNonRecursion(TreeNode root) {
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

    // 后序遍历
    public void afterOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.println(root.val);
    }


    // 非递归版本后序遍历
    public void afterOrderNonRecursion(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.println(res.pop().val + " ");
        }
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
}
