package cn.laochou.字节常见笔试题.搜索旋转排序数组;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 21:02
 * @Version: 1.0
 */
public class Solution {

    /**
     * 这个的思路，首先找到旋转下标，然后通过二分查找法就行
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int rotateIndex = findRotateIndex(nums);
        // 说明没有旋转
        if(rotateIndex == -1) {
            return findTarget(nums, target, 0, nums.length - 1);
        }
        // 说明有旋转
        if(target >= nums[0]) {
            return findTarget(nums, target, 0, rotateIndex - 1);
        }else {
            return findTarget(nums, target, rotateIndex, nums.length - 1);
        }
    }


    private int findRotateIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] >= nums[right]) {
            if(right - left == 1) {
                return right;
            }
            int mid = (left + right) / 2;
            if(nums[mid] >= nums[left]) {
                left = mid;
            }
            if(nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return -1;
    }


    private int findTarget(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


}
