package cn.laochou.day702.最接近的三数之和;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/2 0002 8:27
 * @Version: 1.0
 */
public class Solution {


    public int threeSumClosest(int[] nums, int target) {
        // 其实这个跟三数之后差不太多
        if(nums == null || nums.length == 0) {
            return target;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int number = sum - target;
                if(Math.abs(number) < min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if(number == 0) {
                    left++;
                    right--;
                }
                if(number > 0) {
                    right--;
                }
                if(number < 0) {
                    left++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, 4}, 1));
    }

}
