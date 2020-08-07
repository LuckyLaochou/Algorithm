package cn.laochou.smartX.字符串解码;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/18 0018 17:14
 * @Version: 1.0
 */
public class Solution {


    /**
     * 字符串解码
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        // 使用两个栈
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> letters = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if(c - '0' >= 0 && c - '0' <= 9) {
                numbers.push(c - '0');
                index++;
                continue;
            }
            if(c == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder str = new StringBuilder();
                while (!letters.isEmpty() && letters.peek() != '[') {
                    str.append(letters.pop());
                }
                letters.pop();
                String item = str.toString();
                int number = numbers.isEmpty() ? 0 : numbers.pop();
                for(int i = 0; i < number; i++) {
                    stringBuilder.append(item);
                }
                char[] cs = stringBuilder.reverse().toString().toCharArray();
                for(char citem : cs) {
                    letters.push(citem);
                }
            }else {
                letters.push(c);
            }
            index++;
        }
        StringBuilder res = new StringBuilder();
        while (!letters.isEmpty()) {
            res.append(letters.pop());
        }
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("100[leetcode]"));
    }

}
