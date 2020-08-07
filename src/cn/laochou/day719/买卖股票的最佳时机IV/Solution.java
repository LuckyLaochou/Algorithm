package cn.laochou.day719.买卖股票的最佳时机IV;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/19 0019 16:49
 * @Version: 1.0
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                if(i - 1 == -1) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i][j-1][0], dp[i][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i][j-1][1], dp[i][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

}
