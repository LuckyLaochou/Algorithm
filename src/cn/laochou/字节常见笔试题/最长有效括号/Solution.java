package cn.laochou.字节常见笔试题.最长有效括号;

import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 9:32
 * @Version: 1.0
 */
public class Solution {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int maxAns = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.add(i);
                }else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
