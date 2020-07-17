package cn.laochou.day701.删除排序数组中的重复项;

import java.util.ArrayList;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 13:18
 * @Version: 1.0
 */
public class Solution {

    /**
     * 这题目很明显使用双指针法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // 当前的位置
        int res = 1;
        // 表示的是插入的位置
        int p1 = 0;
        // 表示的是需要插入元素的位置
        int p2 = 0;
        while (p2 < nums.length) {
            while (p2 < nums.length && nums[p1] == nums[p2]) {
                // 我们需要找到插入点
                p2++;
                if(p2 == nums.length) {
                    return res;
                }
            }
            nums[p1 + 1] = nums[p2];
            p1++;
            p2++;
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(solution.removeDuplicates(new int[]{1, 1}));
    }

}
