package cn.laochou.day710.颜色分类;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/10 0010 16:03
 * @Version: 1.0
 */
public class Solution {

    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 2) return;

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len -1 ] = 2

        // 循环终止条件时 i == two，那么循环可以继续的条件时 i < two
        // 为了保证初始化的时候【0，zero)为空，设置zero为0
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;
        // 为了保证初始化的时候【two,len-1]为空，设置two=len
        // 所以下面遍历到2的时候，先减，再交换。
        int two = len;
        int i = 0;
        while (i < len) {
            if(nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            }else if(nums[i] == 1) {
                i++;
            }else {
                two--;
                swap(nums, i, two);
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
