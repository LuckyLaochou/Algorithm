package cn.laochou.day818.多重背包;

/**
 * 多重背包
 * @Author: ITLaochou
 * @Date: 2020/8/19 0019 0:20
 * @Version: 1.0
 */
public class Solution {


    public static void main(String[] args) {

    }


    public static int multiBackpack(int N, int W, int[] numbers, int[] weights, int[] values) {
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = W; j >= weights[i-1]; j--) {
                for(int k = 0; k <= numbers[i-1] && k * weights[i-1] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weights[i-1]] + k * values[i]);
                }
            }
        }
        return dp[N];
    }


}
