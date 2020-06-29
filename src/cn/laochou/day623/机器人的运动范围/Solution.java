package cn.laochou.day623.机器人的运动范围;

public class Solution {

    public int movingCount(int m, int n, int k) {
        // 标记数组
        boolean[][] flag = new boolean[m][n];
        return dfs(0,0, m, n , k , flag);
    }


    private int dfs(int row, int col, int m, int n, int k, boolean[][] flag) {
        // 检查是否可以进入
        int count = 0;
        if(check(row, col, m, n, k, flag)) {
            flag[row][col] = true;
            count = 1 + dfs(row + 1, col, m, n, k, flag) + dfs(row -1, col, m, n, k, flag) + dfs(row, col + 1, m, n, k, flag) + dfs(row, col-1, m, n, k, flag);
        }
        return count;
    }



    private boolean check(int row, int col, int m, int n, int k, boolean[][] flag) {
        if(row < 0 || row >= m || col < 0 || col >= n || flag[row][col]) {
            return false;
        }
        return getSum(row) + getSum(col) <= k;
    }

    private int getSum(int target) {
        int sum = 0;
        while (target > 0) {
            sum += target % 10;
            target /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
    }

}
