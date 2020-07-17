package cn.laochou.day629.缺失的数字;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 16:51
 * @Version: 1.0
 */
public class Solution {


    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int index = (left + right) / 2;
            if(nums[index] == index) {
                left = index + 1;
            }
            if(nums[index] > index) {
                right = index - 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

}
