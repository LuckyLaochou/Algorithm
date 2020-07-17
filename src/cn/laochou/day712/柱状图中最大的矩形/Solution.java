package cn.laochou.day712.柱状图中最大的矩形;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/12 0012 10:40
 * @Version: 1.0
 */
public class Solution {


    // 我们通过单调栈来解决这个问题(我们通过单调栈来得到左右的边界点，从而可以计算出来)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            // 向左边扩展
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // 需要清除一下
        stack.clear();
        for(int i = n - 1; i >= 0; i--) {
            // 向右边扩展
            // 如果当前值比后面的值还大，那么就只能到达自己这里了
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 计算
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{6}));
    }


}
