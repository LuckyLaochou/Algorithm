package cn.laochou.day626.跳跃游戏;

import java.util.Map;

public class Solution {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int length = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= length) {
                length = Math.max(length, i + nums[i]);
                if(length >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solution.canJump(new int[]{0}));
        System.out.println(solution.canJump(new int[]{3,0,8,2,0,0,1}));
    }

}
