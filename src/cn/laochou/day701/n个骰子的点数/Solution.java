package cn.laochou.day701.n个骰子的点数;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 8:35
 * @Version: 1.0
 */
public class Solution {

    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int s = i; s <= 6 * i; s++) {
                for(int j = 1; j <= 6; j++) {
                    if(s - j < i -1) {
                        break;
                    }
                    // 当前N个骰子出现的点数之和等于前一次出现的点数之和加上这次出现的点数。
                    dp[i][s] += dp[i-1][s-j];
                }
            }
        }
        double total = Math.pow((double)6, (double)n);
        double[] ans = new double[5 * n + 1];
        for(int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double)dp[n][i]) / total;
        }
        return ans;
    }

}
