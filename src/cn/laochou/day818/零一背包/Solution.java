package cn.laochou.day818.零一背包;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/18 0018 23:06
 * @Version: 1.0
 */
public class Solution {

    // 01 背包 也就是每个物品只能选一次或者不选。
    public static int getMaxValue(int N, int M, int[] V, int[] W) {
        // 表示的是前N个物品，在体重为M的最大值
        int[][] dp = new int[N+1][M + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(W[i-1] > j) {
                    // 说明放不下，那么就是
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i-1]] + V[i-1]);
                }
            }
        }
        return dp[N-1][M];
    }

}
