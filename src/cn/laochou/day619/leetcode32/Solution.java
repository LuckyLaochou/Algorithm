package cn.laochou.day619.leetcode32;

import java.util.Stack;

public class Solution {

    /**
     * 最长有效括号（使用暴力法破解）
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 2; j <= s.length(); j+=2) {
                String temp = s.substring(i, j);
                if(isValid(temp)) {
                    maxLen = Math.max(maxLen, (j - i));
                }
            }
        }
        return maxLen;
    }


    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push('(');
            }else if(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 通过 stack来实现
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }


    /**
     * 扫描两边
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }
            if(left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }else {
                left = 0;
                right = 0;
            }
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }
            if(left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }else {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("))(())"));
    }

}
