package cn.laochou.day629.左旋字符串;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 21:22
 * @Version: 1.0
 */
public class Solution {


    public String reverseLeftWords(String s, int n) {
        if(s == null || s.length() == 0 || s.length() < n) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(n)).append(s.substring(0, n));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
    }

}
