package cn.laochou.day712.最大矩形;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/12 0012 12:15
 * @Version: 1.0
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            System.out.println(Arrays.toString(dp));
            maxArea = Math.max(maxArea, getRectangle(dp));
        }
        return maxArea;
    }



    private int getRectangle(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(solution.getRectangle(new int[] {3, 1, 3, 2, 2}));
    }

}
