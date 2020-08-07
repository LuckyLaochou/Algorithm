package cn.laochou.day721.二叉树的左视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/21 0021 16:52
 * @Version: 1.0
 */
public class Solution {


    public List<TreeNode> leftView(TreeNode root) {
        if(root == null) return null;
        // 层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> ans = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(i == 0) ans.add(node);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<TreeNode> ans = solution.leftView(root);
        for(TreeNode node : ans) {
            System.out.println(node.val);
        }

    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {this.val = val;}
}
