package cn.laochou.day721.搜索旋转排序数组;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/21 0021 17:18
 * @Version: 1.0
 */
public class Solution {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     * 新玩法
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // 确定在那边
            if(target >= nums[0]) {
                // 那么一定在走边
                if(nums[mid] < nums[0]) {
                    // 说明此时mid在右边
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else {
                // 那么一定在右边
                if(nums[mid] >= nums[0]) {
                    // 说明此时mid在走边
                    nums[mid] = Integer.MIN_VALUE;
                }
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



    public int searchCanon(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int index = findRotateIndex(nums);
        if(index == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        // 然后就通过二分法查找我们的target
        if(target >= nums[0]) {
            return binarySearch(nums, 0, index - 1, target);
        }else {
            return binarySearch(nums, index, nums.length - 1, target);
        }
    }


    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findRotateIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] >= nums[right]) {
            if(right - left == 1) {
                return right;
            }
            int mid = left + (right - left) / 2;
            // 说明中间比左边大，说明旋转索引在后面
            if(nums[mid] >= nums[left]) {
                left = mid;
            }
            if(nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.searchCanon(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

}
