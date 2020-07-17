package cn.laochou.day701.数组中的第K个最大元素;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 21:40
 * @Version: 1.0
 */
public class Solution {


    // 可以用一个堆来搞。
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // 先建立一个K大小的堆
        buildHeap(nums, k);
        // 剩下的就是heapify
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > nums[0]) {
                swap(nums, i, 0);
                heapify(nums, k-1);
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }


    private void heapify(int[] nums, int k) {
        int currentIndex = 0;
        int leftIndex = 2 * currentIndex + 1;
        int rightIndex = 2 * currentIndex + 2;
        int minIndex;
        while(leftIndex <= k) {
            if(nums[rightIndex] < nums[leftIndex] && rightIndex <= k) {
                minIndex = rightIndex;
            }else {
                minIndex = leftIndex;
            }
            // 说明本身就是最小堆
            if(nums[currentIndex] < nums[minIndex]) {
                minIndex = currentIndex;
                break;
            }
            swap(nums, minIndex, currentIndex);
            currentIndex = minIndex;
            leftIndex = 2 * currentIndex + 1;
            rightIndex = 2 * currentIndex + 2;
        }

    }

    // 弄一个最小堆
    private void buildHeap(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            while(nums[currentIndex] < nums[fatherIndex]) {
                // 必须swap
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
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }


}
