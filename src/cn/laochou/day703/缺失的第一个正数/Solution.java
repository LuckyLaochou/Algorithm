package cn.laochou.day703.缺失的第一个正数;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 10:14
 * @Version: 1.0
 */
public class Solution {


//    public int firstMissingPositive(int[] nums) {
//        if(nums == null || nums.length == 0) return 1;
//        // 我们可以先遍历一次，找到最大值，然后递减就完了
//        int max = 0;
//        int min = Integer.MAX_VALUE;
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++) {
//            if(i > 0 && nums[i] == nums[i-1]) {
//                continue;
//            }
//            if(nums[i] > 0) {
//                max = Math.max(max, nums[i]);
//                min = Math.min(min, nums[i]);
//                sum += nums[i];
//            }
//        }
//        // 说明都比1 大
//        if(min > 1) {
//            return 1;
//        }
//        // 该范围没有缺失
//        if(sum == (max * (max + 1)) / 2) {
//            return max + 1;
//        }
//        sum = max * (max + 1) / 2;
//        for(int i = 0; i < nums.length; i++) {
//            if(i > 0 && nums[i] == nums[i-1]) {
//                continue;
//            }
//            if(nums[i] > 0) {
//                sum -= nums[i];
//            }
//        }
//        return sum;
//    }


    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
         Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 1}));
    }

}
