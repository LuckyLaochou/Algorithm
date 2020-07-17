package cn.laochou.day712.不同的二叉树;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/12 0012 15:35
 * @Version: 1.0
 */
public class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j <= i; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }

}
