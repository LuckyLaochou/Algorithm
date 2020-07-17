package cn.laochou.字节常见笔试题.数组中的第K个最大元素;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 21:52
 * @Version: 1.0
 */
public class Solution {


    /**
     * 使用一个最小堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= k) return 0;
        buildHeap(nums, k);
        // 开始堆化
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > nums[0]) {
                swap(nums, 0, i);
                heapify(nums, k - 1);
            }
        }
        return nums[0];
    }


    private void heapify(int[] nums, int k) {
        int currentIndex = 0;
        int leftIndex = currentIndex * 2 + 1;
        int rightIndex = currentIndex * 2 + 2;
        int minIndex;
        while (leftIndex <= k) {
            if (nums[rightIndex] < nums[leftIndex] && rightIndex < k) {
                minIndex = rightIndex;
            } else {
                minIndex = leftIndex;
            }
            // 说明此时已经是最小堆了
            if(nums[currentIndex] <= nums[minIndex]) {
                break;
            }
            swap(nums, currentIndex, minIndex);
            currentIndex = minIndex;
            leftIndex = minIndex * 2 + 1;
            rightIndex = minIndex * 2 + 2;
        }
    }


    private void buildHeap(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            int currentIndex = i;
            int fatherIndex = (i - 1) / 2;
            while (nums[currentIndex] < nums[fatherIndex]) {
                swap(nums, currentIndex, fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }


}
