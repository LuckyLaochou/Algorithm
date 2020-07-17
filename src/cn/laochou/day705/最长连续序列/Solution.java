package cn.laochou.day705.最长连续序列;

import java.util.HashSet;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 9:06
 * @Version: 1.0
 */
public class Solution {


    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int item : nums) {
            set.add(item);
        }
        int longLength = 0;
        for(int item : nums) {
            if(!set.contains(item - 1)) {
                int currentLength = 0;
                int currentNumber = item;
                while (set.contains(currentNumber)) {
                    currentNumber++;
                    currentLength++;
                }
                longLength = Math.max(currentLength, longLength);
            }
        }
        return longLength;
    }

}
