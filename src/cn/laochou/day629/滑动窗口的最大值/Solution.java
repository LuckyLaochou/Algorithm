package cn.laochou.day629.滑动窗口的最大值;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 21:32
 * @Version: 1.0
 */
public class Solution {

    /**
     * AC
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return nums;
        }
        int[] res = new int[nums.length - k];
        for(int i = 0; i < nums.length - 1 - k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
