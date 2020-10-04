package cn.laochou.day617.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * AC
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            // 首先得去重（注意第一个位置）
            // 解释，因为前面这个值已经用过了，所以不能选（前提是前面得用过）
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int number = nums[i];
            while (left < right) {
                int count = number + nums[left] + nums[right];
                if (count == 0) {
                    result.add(Arrays.asList(number, nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if(count > 0) {
                    right--;
                }
                if(count < 0) {
                    left++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        result.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

}
