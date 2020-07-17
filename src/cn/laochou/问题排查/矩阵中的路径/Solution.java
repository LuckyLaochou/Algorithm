package cn.laochou.问题排查.矩阵中的路径;

import java.util.HashSet;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/6 0006 16:12
 * @Version: 1.0
 */
public class Solution {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || matrix.length == 0) return false;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(matrix, rows, cols, str, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(char[] matrix, int rows, int cols, char[] str, int index, int i, int j) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[i * cols + j] != str[index]) {
            return false;
        }
        if(index == str.length - 1) {
            return true;
        }
        char temp = matrix[i * cols + j];
        System.out.println(temp + " " + index + " " + i + " " + j);
        matrix[i * cols + j] = '/';
        boolean result = dfs(matrix, rows, cols, str, index + 1, i + 1, j) || dfs(matrix, rows, cols, str, index + 1, i - 1, j) || dfs(matrix, rows, cols, str, index+1, i, j + 1) || dfs(matrix, rows, cols, str, index + 1, i, j - 1);
        matrix[i * cols + j] = temp;
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String matrix = "ABCESFCSADEE";
        String str = "ABCCED";
        System.out.println(solution.hasPath(matrix.toCharArray(), 3, 4, str.toCharArray()));
    }

}
