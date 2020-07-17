package cn.laochou.day629.和为S的两个数字;

import java.util.HashMap;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 21:08
 * @Version: 1.0
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {0, 0};
        }
        // 使用一个HashMap吧
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && map.get(target-nums[i]) != i) {
                return new int[] {nums[i], target - nums[i]};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[] {0, 0};
    }

}
