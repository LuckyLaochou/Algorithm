package cn.laochou.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergerSort {


    public void mergerSort(int[] nums) {
        mergerSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void mergerSort(int[] nums, int left, int right) {
        // 辅助数组
        int[] temp = new int[nums.length];
        int mid;
        if(left < right) {
            mid = (left + right) / 2;
            mergerSort(nums, left, mid);
            mergerSort(nums, mid + 1, right);
            merger(nums, left, mid, right, temp);
        }
    }


    private void merger(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= right) {
            if(nums[i] >= nums[j]) {
                temp[index++] = nums[j++];
            }else {
                temp[index++] = nums[i++];
            }
        }
        while(i <= mid) {
            temp[index++] = nums[i++];
        }
        while(j <= right) {
            temp[index++] = nums[j++];
        }

        // 最后合
        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }


    public static void main(String[] args) {
        MergerSort mergerSort = new MergerSort();
        mergerSort.mergerSort(new int[]{1, 2, 4, 3, 9, 8, 0});
    }
}
