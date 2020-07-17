package cn.laochou.猿辅导常见笔试题.最长连续递增序列;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 18:24
 * @Version: 1.0
 */
public class Solution {

    /**
     * 用双指针吧
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int start = 0;
        int end = start + 1;
        int length = nums.length;
        int max = 1;
        while (start < length && end < length) {
            int cur = nums[start];
            while (end < length && nums[end] > cur) {
                cur = nums[end];
                max = Math.max(max, end - start + 1);
                end++;
            }
            start = end;
            end = start + 1;
        }
        return max;
    }


    public int findLengthOfLCISDP(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            }else {
                dp[i] = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

}
