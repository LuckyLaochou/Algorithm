package cn.laochou.字节常见笔试题.买卖股票;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 19:27
 * @Version: 1.0
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        int[] dp = new int[prices.length];
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < i; j++) {
                if(prices[i] > prices[j]) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j]);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

}
