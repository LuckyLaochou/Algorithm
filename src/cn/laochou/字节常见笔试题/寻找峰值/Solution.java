package cn.laochou.字节常见笔试题.寻找峰值;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 17:07
 * @Version: 1.0
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 说明是降序序列
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            }else {
                // 说明是升序序列
                left = mid + 1;
            }
        }
        return left;
    }

}
