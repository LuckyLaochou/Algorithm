package cn.laochou.day714.零一背包;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/14 0014 18:00
 * @Version: 1.0
 */
public class Solution {

    public int knapSpack(int[] values, int[] weights, int N, int W) {
        int[][] dp = new int[N+1][W+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= W; j++) {
                if(weights[i] > j) {
                    // 表示放不下了
                    dp[i][j] =  dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j - weights[i]] + values[i-1]);
                }
            }
        }
        return dp[N][W];
    }

}
