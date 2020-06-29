package cn.laochou.day623.二叉树中和为某一值的路径;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Solution {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(root, sum, res, new ArrayList<>());
        return res;
    }


    private void recursion(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        // 首先判断root是否为空
        if(root == null) {
            return;
        }
        path.add(root.val);
        int count = getCount(path);
        if(count == sum) {
            res.add(new ArrayList<>(path));
        }
        recursion(root.left, sum, res, path);
        recursion(root.right, sum, res, path);
        path.remove(path.size() - 1);
    }


    private int getCount(List<Integer> path) {
        System.out.println(Arrays.toString(path.toArray()));
        Optional<Integer> optional = path.stream().reduce(Integer::sum);
        return optional.orElse(0);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> res = solution.pathSum(root, 22);
        System.out.println(res.size());
        res.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
}
