package cn.laochou.day615.leetcode14;

public class Solution {

    // 寻找最长共同子串
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String commonPrefix = getTwoStringCommonPrefix(strs[0], strs[1]);
        for(int i = 2; i < strs.length; i++) {
            commonPrefix = getTwoStringCommonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.length() == 0) {
                break;
            }
        }
        return commonPrefix;
    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        int index = 0;
        for (int j = 1; j < strs.length; j++) {
            char c = first.charAt(index);
            // 注意这里必须使用 <=
            if(strs[j].length() <= index || strs[j].charAt(index) != c) {
                break;
            }else {
                index++;
            }
        }
        return first.substring(0, index);
    }


    private String getTwoStringCommonPrefix(String str1, String str2) {
        StringBuilder commonPrefix = new StringBuilder();
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length) {
            if (str1.charAt(index) == str2.charAt(index)) {
                commonPrefix.append(str1.charAt(index));
                index++;
            }else {
                break;
            }
        }
        return commonPrefix.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
    }

}
