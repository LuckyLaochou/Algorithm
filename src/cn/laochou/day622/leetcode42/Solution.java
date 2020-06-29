package cn.laochou.day622.leetcode42;

import java.util.Stack;

public class Solution {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int length = height.length;
        if(length < 3) {
            return 0;
        }
        int[] leftMaxArr = new int[length];
        int[] rightMaxArr = new int[length];
        leftMaxArr[0] = height[0];
        rightMaxArr[length-1] = height[length-1];
        // 先遍历左边的，找到左边最大值
        for(int i = 1; i < length; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i]);
        }
        // 在遍历右边，找到右边最大
        for(int i = length - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i+1], height[i]);
        }
        for(int i = 0; i < length; i++) {
            ans += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return ans;
    }


    public int trap2(int[] heights) {
        // 我们使用单调栈来解决这个问题
        // 该单调栈用来保存索引
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int index = 0;
        while (index < heights.length) {
            while (!stack.isEmpty() && heights[index] > heights[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                // 当前能形成低洼的高度
                int height = Math.min(heights[index], heights[stack.peek()]) - heights[top];
                int weight = index - stack.peek() - 1;
                ans += (height * weight);
            }
            stack.push(index++);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
