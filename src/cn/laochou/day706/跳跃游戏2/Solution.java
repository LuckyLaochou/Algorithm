package cn.laochou.day706.跳跃游戏2;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/6 0006 8:33
 * @Version: 1.0
 */
public class Solution {


    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] >= 0) return 0;
        int canGet;
        int start = 0;
        int res = 1;
        int index = -1;
        while (start < nums.length) {
            if(index != -1) {
                start = index;
                res++;
            }
            canGet = start + nums[start];
            if(canGet >= nums.length - 1) return res;
            // 从 canGet中需要找到是否能更新到最长
            int i = start + 1;
            // 用来记录比canGet大的小标.
            index = -1;
            int maxLen = canGet;
            while (i <= maxLen && i < nums.length) {
                if(i + nums[i] > canGet) {
                    // 找到最大的能达到的小标。
                    canGet = i + nums[i];
                    index = i;
                }
                i++;
            }
        }
        return 0;
    }



    public int jump2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length;
        // 最大可达下标
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for(int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if(i == end) {
                steps++;
                end = maxPosition;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1, 1, 1, 1}));
    }

}
