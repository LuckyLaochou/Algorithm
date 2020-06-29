package cn.laochou.day621.leetcode33;

import java.util.Arrays;

public class Solution {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * AC
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        // first 我们可以通过二分查找法，查找target的下标
        int index = binarySearch(nums, target);
        if(index == -1) {
            return new int[]{-1, -1};
        }
        // 如果找到了对应的小标，就有点麻烦了呀
        int left = index;
        int right = index;
        for(int i = 0; i < left; i++) {
            if(nums[i] == target) {
                left = i;
            }
        }
        for(int i = right; i < nums.length; i++) {
            if(nums[i] == target) {
                right = i;
            }
        }
        return new int[]{left, right};
    }

    /**
     * AC
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int left = leftBinarySearch(nums, target);
        int right = rightBinarySearch(nums, target);
        return new int[]{left, right};
    }

    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
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


    /**
     * 用来寻找左边界
     * @param nums
     * @param target
     * @return
     */
    private int leftBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                // 因为我们需要查找左边界，所以我们需要不断的缩小右边的区间
                right = mid - 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 需要检查一下(特殊情况：数组中的数都比target小)
        if(left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * 用来寻找右边界
     * @param nums
     * @param target
     * @return
     */
    private int rightBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 需要检查一下（特殊情况：数组中的数都比target大）
        if(right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));

        System.out.println(Arrays.toString(solution.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8)));

    }

}
