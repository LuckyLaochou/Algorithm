package cn.laochou.day616.leetcode3;

import java.util.HashSet;

public class Solution {

    /**
     * AC
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 采用滑动窗口
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int length = s.length();
        int maxLength = Integer.MIN_VALUE;
        while (i < length && j < length) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                maxLength = Math.max(i-j, maxLength);
            }else {
                set.remove(s.charAt(j++));
            }

        }
        return maxLength;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }

}
