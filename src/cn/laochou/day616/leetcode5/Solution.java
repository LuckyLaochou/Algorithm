package cn.laochou.day616.leetcode5;

public class Solution {


    /**
     * AC
     * 采用动态规划的算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String result = "";
        int length = s.length();
        // 代表 i 到 j 是否回文
        boolean[][] palindrome = new boolean[length][length];
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                palindrome[j][i] = (i - j <= 2 || palindrome[i-1][j+1]) && s.charAt(j) == s.charAt(i);
                if (palindrome[j][i]) {
                    if(i - j > maxLength) {
                        maxLength = i - j;
                        result = s.substring(j, i+1);
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }

}
