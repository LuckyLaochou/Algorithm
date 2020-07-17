package cn.laochou.字节常见笔试题.翻转单词;

import com.sun.org.apache.bcel.internal.generic.FADD;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/7 0007 9:41
 * @Version: 1.0
 */
public class Solution {

    /**
     * 这个方法有点问题，能处理正常的用例.
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 我们可以看成是单词反转
        s = s.trim();
        if(s.equals("")) return "";
        char[] cs = s.toCharArray();
        reverse(cs, 0, cs.length - 1);
        System.out.println(String.valueOf(cs));
        int left = 0;
        int right = 0;
        while(left < cs.length) {
            while(right < cs.length && cs[right] != ' ') {
                System.out.println(left + " " + right);
                right++;
            }
            reverse(cs, left, right - 1);
            left = right + 1;
            right = left;
        }
        return String.valueOf(cs);
    }


    private void reverse(char[] cs, int left, int right) {
        while(left < right) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }

}
