package cn.laochou.day719.买卖股票的最佳时机I;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/19 0019 14:37
 * @Version: 1.0
 */
public class Solution {

    public int maxProfit(int[] prices) {
        // 买卖股票
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        // 两种状态（n表示天，2表示状态）
        // dp[i][0] 表示第i天未持有 的利润
        // dp[i][1] 表示第i天持有 的利润
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 因为只能买卖一次，所以不能用以前的利润
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }

}
