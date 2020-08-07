package cn.laochou.day719.买卖股票的最佳时机III;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/19 0019 17:25
 * @Version: 1.0
 */
public class Solution {


    public int maxProfit(int[] prices) {
        // 最多可以进行两笔交易
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0; i < n ; i++) {
            for(int j = 1; j <= k; j++) {
                if(i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

}
