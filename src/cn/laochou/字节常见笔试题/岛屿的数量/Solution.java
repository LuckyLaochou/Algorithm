package cn.laochou.字节常见笔试题.岛屿的数量;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 14:29
 * @Version: 1.0
 */
public class Solution {


    private int[][] flag = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        // 经典的回溯问题
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int x = grid.length;
        int y = grid[0].length;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }


    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if(grid[i][j] == '0') {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            for(int k = 0; k < flag.length; k++) {
                dfs(grid, i + flag[k][0], j + flag[k][1]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'},
                {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
    }

}
