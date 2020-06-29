package cn.laochou.day620.leetcode33;

public class Solution {


    /**
     * 搜索旋转
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 先找到旋转点（二分法）
        // 保证了一个数据的不重复，所以不存在一个找不到的get
        int left = 0;
        int right = nums.length - 1;
        // 旋转点
        int indexMid = 0;
        while (nums[left] >= nums[right]) {
            if(right - left == 1) {
                indexMid = right;
                break;
            }
            int mid = (left + right) / 2;
            System.out.println(left + " " + right);
            if(nums[mid] >= nums[left]) {
                left = mid;
            }
            if(nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        left = 0;
        right = nums.length - 1;
        // 没有旋转点的情况
        if(indexMid == 0) {
            return find(target, left, right, nums);
        }
        if(target >= nums[left]) {
            return find(target, left, indexMid - 1, nums);
        }else {
            return find(target, indexMid, right, nums);
        }
    }


    private int find(int target, int left, int right, int[] arr) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(target > arr[mid]) {
                left = mid + 1;
            }
            if(target < arr[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{1,3}, 0));
    }
}
