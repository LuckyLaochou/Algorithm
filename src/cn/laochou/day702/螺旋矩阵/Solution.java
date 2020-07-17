package cn.laochou.day702.螺旋矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/2 0002 8:39
 * @Version: 1.0
 */
public class Solution {


    /**
     * 螺旋矩阵
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        while (row > start * 2 && col > start * 2) {
            printMatrix(res, matrix, row, col, start);
            start++;
        }
        return res;
    }


    private void printMatrix(List<Integer> res, int[][] matrix, int row, int col, int start) {
        int endX = row - 1 - start;
        int endY = col - 1 - start;
        // 从左往右
        for(int i = start; i <= endY; i++) {
            res.add(matrix[start][i]);
        }
        // 从上往下
        if(start < endX) {
            for(int i = start + 1; i <= endX; i++) {
                res.add(matrix[i][endY]);
            }
        }
        // 从右往左
        if(start < endY && start < endX) {
            for(int i = endY - 1; i >= start; i--) {
                res.add(matrix[endX][i]);
            }
        }

        // 从下往上
        if(start < endX - 1 && start < endY) {
            for(int i = endX - 1; i > start; i--) {
                res.add(matrix[i][start]);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(res.toArray()));
    }

}
