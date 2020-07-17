package cn.laochou.day706.不同的路径2;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/6 0006 8:26
 * @Version: 1.0
 */
public class Solution {

    /**
     * 这个还是比较简单的。就是中间有障碍
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        for(int i = 0;i < m; i++) {
            // 如果阻塞了，就跳出。因为走不通，所以是0
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            // 如果走得通，那么当前一列中的路径只有一条。
            dp[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            // 如果走得通，那么当前一行中的路径也只有一条。
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n ; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}
