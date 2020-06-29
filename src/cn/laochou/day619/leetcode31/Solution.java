package cn.laochou.day619.leetcode31;

import java.util.Arrays;

public class Solution {

    /**
     * LeetCode 31 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 从后面往前面找，找到一个比他小的。
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == 0) {
                Arrays.sort(nums);
                return;
            }else {
                // 如果后面的一个比前面的大，就需要进行替换了（这样才可以获取下一个最大）
                if(nums[i] > nums[i-1]) {
                    // need change
                    Arrays.sort(nums, i, nums.length);
                    for(int j = i; j < nums.length; j++) {
                        if(nums[j] > nums[i-1]) {
                            int temp = nums[i-1];
                            nums[i-1] = nums[j];
                            nums[i] = temp;
                            return;
                        }
                    }
                }
            }
        }
    }

}
