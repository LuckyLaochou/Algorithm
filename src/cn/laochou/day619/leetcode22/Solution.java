package cn.laochou.day619.leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, 0, n);
        return res;
    }

    private void generate(List<String> res, String cur, int index, int open, int close,  int n) {
        if(index == 2 * n) {
            res.add(cur);
            return;
        }
        if(open < n) {
            generate(res, cur + "(", index + 1, open + 1, close, n);
        }
        if(open > close) {
            generate(res, cur + ")", index + 1, open, close + 1, n);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        res.forEach(System.out::println);
    }


}
