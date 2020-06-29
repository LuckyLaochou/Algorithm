package cn.laochou.day624.剪绳子;

public class Solution {

    /**
     * 使用动规
     * @param n
     * @return
     * 假设一个绳子，我们将其分为两段。这两段的乘积最大值那么不就是我们需要的最大值吗？
     */
    public int cuttingRope(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int[] dp = new int[n+1];
        // 这里的数列，表示的是 长度为i的与1的乘积。
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int maxLen = Integer.MIN_VALUE;
        int temp;
        for(int i = 4; i <= n; i++) {
            maxLen = 0;
            for(int j = 1; j <= i / 2; j++) {
                temp = dp[i-j] * dp[j];
                if(temp > maxLen) {
                    maxLen = temp;
                }
            }
            dp[i] = maxLen;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }

}
