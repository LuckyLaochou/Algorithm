package cn.laochou.无尽哥804笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/5 0005 7:54
 * @Version: 1.0
 */
public class Solve2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] times = new int[k];
        for(int i = 0; i < k; i++) {
            times[i] = scanner.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i <= n; i++) {
            if(countNum(times, dp[i-1]) >= i) {
                dp[i] = dp[i-1];
                continue;
            }
            for(int j = 0; j < k; j++) {
                dp[i] = Math.min(dp[i], dp[i-1] - dp[i-1] % times[j] + times[j]);
            }
        }
        System.out.println(dp[n]);
    }


    public static int countNum(int[] arr, int T) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            count += T / arr[i];
        }
        return count;
    }
}
