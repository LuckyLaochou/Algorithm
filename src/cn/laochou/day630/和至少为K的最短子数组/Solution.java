package cn.laochou.day630.和至少为K的最短子数组;

import javax.xml.transform.SourceLocator;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 14:18
 * @Version: 1.0
 */
public class Solution {


    /**
     * 83/93 感觉思想没啥问题，主要是开辟数组太大了
     * @param A
     * @param K
     * @return
     */
    public int shortestSubarray(int[] A, int K) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int[][] dp = new int[A.length][A.length];
        int min = Integer.MAX_VALUE;
        dp[0][0] = A[0];
        if(A[0] == K) {
            return 1;
        }
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = A[i] + dp[j][i-1];
                if(dp[j][i] >= K) {
                    min = Math.min(min, i - j + 1);
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestSubarray(new int[]{2, -1, 2}, 3));
    }

}
