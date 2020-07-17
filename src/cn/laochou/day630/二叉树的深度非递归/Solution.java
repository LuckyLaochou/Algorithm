package cn.laochou.day630.二叉树的深度非递归;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 13:06
 * @Version: 1.0
 * @Decription：采用层次遍历的方法
 */
public class Solution {


    public int getHeight(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            // 有点东西
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                root = queue.poll();
                if(root.left != null) {
                    queue.add(root.left);
                }
                if(root.right != null) {
                    queue.add(root.right);
                }
            }
            res++;
        }
        return res;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
