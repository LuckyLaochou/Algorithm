package cn.laochou.day626.打家劫舍;

public class Solution {

    // 这个是用dp来做
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            // nums[i-1] + dp[i-2] 代表的是 偷今天和隔一天的
            // dp[i-1] 代表的是，今天不偷。
            // dp[i] 代表的是当前偷法的最大值
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length];
    }

}
