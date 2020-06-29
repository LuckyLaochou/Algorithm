package cn.laochou.day617.leetcode17;


import java.util.*;

public class Solution {


    // make a map
    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "xwyz");
    }

    /**
     * AC
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        if (digits.length() == 1) {
            for(char c : map.get(digits.charAt(0)).toCharArray()) {
                result.add(String.valueOf(c));
            }
            return result;
        }
        // 为了防止多层for循环，两两进行循环。
        result = letterTwoCharacter(digits.charAt(0), digits.charAt(1));
        for(int i = 2; i < digits.length(); i++) {
            result = getResult(result, digits.charAt(i));
        }

        return result;
    }


    private List<String> letterTwoCharacter(Character c1, Character c2) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : map.get(c1).toCharArray()) {
            stringBuilder.append(c);
            for(char ct : map.get(c2).toCharArray()) {
                stringBuilder.append(ct);
                result.add(stringBuilder.toString());
                stringBuilder.delete(1, stringBuilder.length());
            }
            stringBuilder.delete(0, 1);
        }
        return result;
    }


    private List<String> getResult(List<String> list, Character c) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : list) {
            stringBuilder.append(s);
            for(char ch : map.get(c).toCharArray()) {
                stringBuilder.append(ch);
                result.add(stringBuilder.toString());
                stringBuilder.delete(s.length(), stringBuilder.length());
            }
            stringBuilder.delete(0, s.length());
        }
        return result;
    }


    /**
     * 通过递归来进行解决
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if(digits.equals("")) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        findCombinations(res, digits, 0, "");
        return res;
    }


    private void findCombinations(List<String> res, String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }
        for(char c : map.get(digits.charAt(index)).toCharArray()) {
            findCombinations(res, digits, index + 1, s + c);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.letterCombinations2("23");
        ans.forEach(System.out::println);
    }

}
