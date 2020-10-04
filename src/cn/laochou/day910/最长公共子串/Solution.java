package cn.laochou.day910.最长公共子串;

/**
 * 最长公共子串
 */
public class Solution {

    public int getLongestSub(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int res = 0;
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLongestSub("laochou", "chouyzl"));
    }

}
