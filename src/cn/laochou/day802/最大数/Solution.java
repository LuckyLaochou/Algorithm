package cn.laochou.day802.最大数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/2 0002 22:59
 * @Version: 1.0
 */
public class Solution {


    public static void main(String[] args) {

    }


    public String largestNumber(int[] nums) {
        List<String> lists = new ArrayList<>();
        for(int item : nums) {
            lists.add(String.valueOf(item));
        }
        lists.sort(new LargeComparator());
        if(lists.get(0).equals("0")) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        lists.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }




}


class LargeComparator implements Comparator<String>  {

    @Override
    public int compare(String o1, String o2) {
        String s1 = o1 + o2;
        String s2 = o2 + o1;
        return s2.compareTo(s1);
    }
}