package cn.laochou.day624.股票的最大利润;

public class Solution {

    /**
     * AC
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 1];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[i] < prices[j]) {
                    dp[i] = Math.max(dp[i], prices[j] - prices[i]);
                }
            }
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
