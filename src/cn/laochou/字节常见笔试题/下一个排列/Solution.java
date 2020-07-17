package cn.laochou.字节常见笔试题.下一个排列;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 16:42
 * @Version: 1.0
 */
public class Solution {


    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int length = nums.length - 1;
        for(int i = length; i >= 0; i--) {
            if(i == 0) {
                Arrays.sort(nums);
                return;
            }
            if(nums[i] > nums[i-1]) {
                // 我们将i到最后进行一个排序，找到一个比他大的进行交换
                Arrays.sort(nums, i, length + 1);
                for(int j = i; j <= length; j++) {
                    if(nums[j] > nums[i-1]) {
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                System.out.println(Arrays.toString(nums));
                return;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[] {1, 3, 2});
    }

}
