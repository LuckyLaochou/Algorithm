package cn.laochou.day618.leetcode10;

public class Solution {


    /**
     * AC(不熟，需要多练)
     * 正则表达式匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        // 终止条件需要想清楚（如果我们的正则表达式为空了，这个时候字符串还没匹配完，说明false。否则说明true）
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if(p.length() > 1 && p.charAt(1) == '*') {
            // 可能是匹配0个，或者匹配多个
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}
