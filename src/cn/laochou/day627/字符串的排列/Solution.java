package cn.laochou.day627.字符串的排列;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public String[] permutation(String s) {

        boolean[] used = new boolean[s.length()];
        List<Character> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        // 通过回溯来解决
        recursion(s.toCharArray(), used, 0, res, path);
        String[] ans = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void recursion(char[] chars, boolean[] used, int index, List<String> res, List<Character> path) {
        if(index == chars.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : path) {
                stringBuilder.append(c);
            }
            String item = stringBuilder.toString();
            if(res.contains(item)) return;
            res.add(stringBuilder.toString());
            return;
        }
        for(int i = 0; i < chars.length; i++) {
            if(!used[i]) {
                used[i] = true;
                path.add(chars[i]);
                recursion(chars, used, index+1, res, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
        System.out.println(Arrays.toString(solution.permutation("dkjphedy")));

    }

}
