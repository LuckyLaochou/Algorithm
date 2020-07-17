package cn.laochou.day705.打家劫舍2;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 10:03
 * @Version: 1.0
 */
public class Solution {


    /**
     * 打家劫舍升级版
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] num1 = new int[nums.length-1];
        int[] num2 = new int[nums.length-1];
        // 打劫第一家
        System.arraycopy(nums, 0, num1, 0, nums.length - 1);
        // 不打劫第一家
        System.arraycopy(nums, 1, num2, 0, nums.length - 1);
        return Math.max(myRob(num1), myRob(num2));
    }


    private int myRob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }


}
