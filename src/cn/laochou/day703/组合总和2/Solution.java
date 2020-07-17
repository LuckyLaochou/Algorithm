package cn.laochou.day703.组合总和2;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 9:57
 * @Version: 1.0
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        // 很明显，通过回溯
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        recursion(candidates, target, res, path, used, 0);
        return res;
    }



    private void recursion(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, boolean[] used, int begin) {
        int sum = getSum(path);
        if(sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < candidates.length; i++) {
            if(candidates[i] > target) {
                continue;
            }
            // 做一次去重
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i-1]) {
                continue;
            }
            if(!used[i]) {
                used[i] = true;
                path.add(candidates[i]);
                recursion(candidates, target, res, path, used, i);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    private int getSum(List<Integer> path) {
        Optional<Integer> optional = path.stream().reduce(Integer::sum);
        return optional.orElse(0);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(new int[] {2,5,2,1,2}, 5);
        res.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

}
