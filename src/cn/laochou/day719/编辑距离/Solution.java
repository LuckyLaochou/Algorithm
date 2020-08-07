package cn.laochou.day719.编辑距离;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/19 0019 18:10
 * @Version: 1.0
 * @Description: 编辑距离
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        // 初始化
        // 当 word1 为空的时候
        for(int i = 1; i <= length2; i++) {
            dp[0][i] = i;
        }
        // 当 word2 为空的时候
        for(int i = 1; i <= length1; i++) {
            dp[i][0] = i;
        }
        // 然后就是正常逻辑
        for(int i = 1; i < length1; i++) {
            for(int j = 1; j < length2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // dp[i-1][j-1] 替换
                    // dp[i-1][j] 删除
                    // dp[i][j-1] 插入
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

}
