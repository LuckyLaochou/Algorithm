package cn.laochou.day714.分割等和子集;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/14 0014 17:39
 * @Version: 1.0
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        // 先求值
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        // 如果不整除，那么肯定不行
        if(sum % 2 != 0) return false;
        // dp[i][j] 表示的是 前i个元素中，是否有能搞出值为j
        boolean[][] dp = new boolean[nums.length+1][sum / 2 + 1];
        for(int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= sum / 2; j++) {
                if(j < nums[i-1]) {
                    // 无法装入
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length - 1][sum / 2];
    }

}
