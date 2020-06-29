package cn.laochou.day618.leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /**
     * AC
     * leetcode 20 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.equals(" ")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if(c == ')') {
                    if (temp != '(') {
                        return false;
                    }
                }
                if(c == ']') {
                    if (temp != '[') {
                        return false;
                    }
                }
                if(c == '}') {
                    if (temp != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }



    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                char cor = stack.isEmpty() ? '#' : stack.pop();
                if (map.get(c) != cor) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(())"));
        System.out.println(solution.isValid("[[]]{}"));
        System.out.println(solution.isValid("(["));
    }

}
