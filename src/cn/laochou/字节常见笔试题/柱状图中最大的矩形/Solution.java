package cn.laochou.字节常见笔试题.柱状图中最大的矩形;

import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 22:49
 * @Version: 1.0
 */
public class Solution {


    /**
     * 使用双指针法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left <= right) {
            int minValue = heights[left];
            int i = left + 1;
            while (i <= right) {
                minValue = Math.min(heights[i], minValue);
                i++;
            }
            // 计算值
            max = Math.max(max, minValue * (right - left + 1));
            System.out.println(left + " " + right + " " + minValue + " : " + (right - left + 1));
            if(heights[left] <= heights[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }


    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> mono_stack = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for(int i = n -1 ; i >= 0; i--) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }

}
