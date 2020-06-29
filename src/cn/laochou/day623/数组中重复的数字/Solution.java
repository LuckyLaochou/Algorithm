package cn.laochou.day623.数组中重复的数字;

/**
 * 数组中重复的数字
 */
public class Solution {


    /**
     * AC
     * @param nums
     * @return
     */
    public int duplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }

}
