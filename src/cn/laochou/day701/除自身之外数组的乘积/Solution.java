package cn.laochou.day701.除自身之外数组的乘积;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 15:22
 * @Version: 1.0
 */
public class Solution {


    public int[] productExceptSelf(int[] nums) {
        // 这个很明显通过 DFS来解
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            int ans = recursion(nums, i);
            res.add(ans);
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i <res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private int recursion(int[] nums, int cur) {
        int res = 1;
        for(int i = 0; i < nums.length; i++) {
            if(i != cur) {
                res *= nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 % 1);
    }
}
