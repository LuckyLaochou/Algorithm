package cn.laochou.day818.完全背包;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/18 0018 23:24
 * @Version: 1.0
 */
public class Solution {

    /**
     * 完全背包，物品可以无限选择
     * @param N N 中物品
     * @param M M 背包的容量
     * @param V N 个物品所对应的价值
     * @param W N 个物品所对应的重量
     * @return
     */
    public int completelyBackpack(int N, int M, int[] V,int[] W) {
        int[][] dp = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= V[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - V[i-1]] + W[i-1]);
                }
            }
        }
        return dp[N][M];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.completelyBackpack(4, 5, new int[]{1, 2, 3 ,4}, new int[]{2, 4, 4, 5}));
    }



}
