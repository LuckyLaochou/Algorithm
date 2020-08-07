package cn.laochou.无尽哥804笔试;

import java.util.Scanner;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/4 0004 22:32
 * @Version: 1.0
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] times = new int[k];
        for(int i = 0; i < k; i++) {
            times[i] = scanner.nextInt();
        }
        System.out.println(getMinTime(k, n, times));
    }


    public static int getMinTime(int k, int n, int[] times) {
        int minTime = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = k - 1; j >= 0; j--) {
                // 如果当前人数所花的时间大于我们的当前理发师所对应的时间。
                if(dp[i] >= times[j]) {
                    dp[i] = Math.min(dp[i], Math.max(times[j], dp[i-1]));
                }
            }
            minTime = Math.min(minTime, dp[i]);
        }
        return minTime;
    }

}
