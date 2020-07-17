package cn.laochou.day716.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/16 0016 10:36
 * @Version: 1.0
 */
public class Solution {

    String[] letterMap = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //letterCombinations
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(ans, digits, 0, "");
        return ans;
    }



    private void dfs(List<String> ans, String digits, int index, String str) {
        if(index == digits.length()) {
            ans.add(str);
            return;
        }
        String letter = letterMap[digits.charAt(index) - '0'];
        for(int i = 0; i < letter.length(); i++) {
            dfs(ans, digits, index + 1, str + letter.charAt(i));
        }
    }


    public static void main(String[] args) {
        String digits = "23";
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations(digits);
        list.forEach(System.out::println);
    }

}
