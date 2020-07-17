package cn.laochou.day629.在排序数组中查找数字;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 16:10
 * @Version: 1.0
 */
public class Solution {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // 通过二分法，找到最左下标和最右下标
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        System.out.println(left);
        System.out.println(right);
        if(left != -1 && right != -1) {
            return right - left + 1;
        }
        return 0;
    }


    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                right = mid - 1;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }

            if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        if(right < 0 || nums[left] != target) {
            return -1;
        }
        return left;
    }


    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                left = mid + 1;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }
            if(nums[mid] < target) {
                left = left + 1;
            }
        }
        if(left > nums.length - 1 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

}
