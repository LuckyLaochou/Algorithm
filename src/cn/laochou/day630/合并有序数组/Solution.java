package cn.laochou.day630.合并有序数组;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 11:08
 * @Version: 1.0
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前搞
        int i = m - 1;
        int j = n - 1;
        int p = m + n - 1;
        while (i >= 0 && j >= 0) {
            if(nums2[j] > nums1[i]) {
                nums1[p--] = nums2[j--];
            }else {
                nums1[p--] = nums1[i--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
    }

}
