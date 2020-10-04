package cn.laochou.day901.接雨水;

import java.util.Stack;

public class Solution {

    public int trap(int[] height) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int length = height.length;
        while (index < length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[index]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                count += (Math.min(height[stack.peek()], height[index]) - height[top]) * (index - stack.peek() - 1);
            }
            stack.add(index);
            index++;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
