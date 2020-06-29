package cn.laochou.day621.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Solution {


    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        recursion(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }


    /**
     *
     * @param candidates
     * @param target
     * @param res
     * @param path
     * @param begin 这个节点相当重要（从当前的节点开始寻找，因为前面的都找过了）
     */
    private void recursion(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int begin) {
        int count = getCountFromPath(path);
        if(count > target){
            return;
        }
        if(count == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 获取当前path里面的值
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            recursion(candidates, target, res, path, i);
            path.remove(path.size() - 1);

        }
    }


    private int getCountFromPath(List<Integer> path) {
        Optional<Integer> optional =  path.stream().reduce(Integer::sum);
        return optional.orElse(0);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[] {2,3,6,7}, 7).forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

}
