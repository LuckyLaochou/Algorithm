package cn.laochou.字节常见笔试题.无重复字符的最长子串;

import java.util.HashSet;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 20:27
 * @Version: 1.0
 */
public class Solution {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int i = 0;
        int j = 0;
        int length = s.length();
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < length && j < length) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                max = Math.max(max, i - j);
            }else {
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

}
