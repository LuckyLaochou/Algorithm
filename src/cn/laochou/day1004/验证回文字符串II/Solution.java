package cn.laochou.day1004.验证回文字符串II;

public class Solution {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isValid(i + 1, j, s) || isValid(i, j - 1, s);
            }else {
                i++;
                j--;
            }
        }
        return true;
    }


    public boolean isValid(int start, int end, String s) {
        while (start <= end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

}
