package cn.laochou.day626.字母异位词分组;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String sortS = sortStr(s);
            if(map.containsKey(sortS)) {
                List<String> temp = map.get(sortS);
                temp.add(s);
            }else {
                List<String> con = new ArrayList<>();
                con.add(s);
                map.put(sortS, con);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }


    private String sortStr(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        res.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

}
