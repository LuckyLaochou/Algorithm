package cn.laochou.day719.买卖股票的最佳时机II;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/19 0019 16:56
 * @Version: 1.0
 */
public class Solution {


    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[] {7,1,5,3,6,4});
    }

}
