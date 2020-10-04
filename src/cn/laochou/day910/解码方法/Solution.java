package cn.laochou.day910.解码方法;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int count;

    public int numDecodings(String s) {
        count = 0;
        char[] cs = s.toCharArray();
        HashSet<String> set = new HashSet<>();
        dfs(cs, 0, "");
        return count;
    }


    private void dfs(char[] cs, int index, String pattern) {
        if(index > cs.length) return;
        if(index == cs.length) {
            count++;
            return;
        }
        int number = cs[index] - '0';
        if(index == cs.length - 1) {
            if(number >= 1 && number <= 26) {
                dfs(cs, index + 1, pattern + cs[index]);
            }
        }else {
            if(number >= 1 && number <= 26) {
                dfs(cs, index + 1, pattern + cs[index]);
            }
            if((cs[index] - '0') * 10 + (cs[index + 1] - '0') <= 26 && (cs[index] - '0') * 10 + (cs[index + 1] - '0') >= 1) {
                dfs(cs, index + 2, pattern + cs[index] + cs[index + 1]);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("223"));
    }

}
