package cn.laochou.day616.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 一遍hashmap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // make a map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int targetNumber = target - nums[i];
            // 这里一定要先校验，后存入map。因为存在一个重复值的情况。
            if(map.containsKey(targetNumber) && map.get(targetNumber) != i) {
                return new int[] {map.get(targetNumber), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {0, 0};
    }

}
