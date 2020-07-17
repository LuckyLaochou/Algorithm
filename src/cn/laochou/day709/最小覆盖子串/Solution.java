package cn.laochou.day709.最小覆盖子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/9 0009 9:29
 * @Version: 1.0
 */
public class Solution {

    // 这个算法存在一些问题（1. 不能解决重复元素 2. 不能解决关于里面套里面的情况）
//    public String minWindow(String s, String t) {
//        if(s == null || s.length() == 0) return "";
//        // 活动窗口来解
//        int index = 0;
//        int length = s.length();
//        int minLength = Integer.MAX_VALUE;
//        String result = "";
//        while (index < length)  {
//            HashSet<Character> set = initT(t);
//            if(set.contains(s.charAt(index))) {
//                int start = index;
//                int end = index;
//                while (end < length) {
//                    char c = s.charAt(end);
//                    set.remove(c);
//                    end++;
//                    if(set.isEmpty()) {
//                        // 说明 end 到 start 包含了所有的字符
//                        if(end - start < minLength) {
//                            minLength = end - start;
//                            result = s.substring(start, end);
//                        }
//                        break;
//                    }
//                }
//                index = end;
//            }else {
//                index++;
//            }
//        }
//        return result;
//    }
//
//    private HashSet<Character> initT(String t) {
//        HashSet<Character> set = new HashSet<>();
//        for(char c : t.toCharArray()) {
//            set.add(c);
//        }
//        return set;
//    }



    private HashMap<Character, Integer> origin = new HashMap<>();
    private HashMap<Character, Integer> current = new HashMap<>();

    public String minWindow(String s, String t) {
        // 左指针，右指针
        int l = 0;
        int r = -1;
        int sLen = s.length();

        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        // 初始化原有结构
        for(char c : t.toCharArray()) {
            origin.put(c, origin.getOrDefault(c, 0) + 1);
        }
        while (r < sLen) {
            ++r;
            if(r < sLen && origin.containsKey(s.charAt(r))) {
                current.put(s.charAt(r), current.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l < r) {
                if(r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if(origin.containsKey(s.charAt(l))) {
                    current.put(s.charAt(l), current.get(s.charAt(l)) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }



    // 比对我们的两个map，看是否都满足
    private boolean check() {
        Iterator iterator = origin.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(current.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

}
