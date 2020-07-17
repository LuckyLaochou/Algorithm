package cn.laochou.day705.打家劫舍;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 10:01
 * @Version: 1.0
 */
public class Solution {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length];
    }

}
