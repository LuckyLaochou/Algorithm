package cn.laochou.day629.数组中数字出现的次数2;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 20:32
 * @Version: 1.0
 */
public class Solution {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // 通过位运算来解决这个问题
        int[] bits = new int[32];
        for(int n : nums) {
            int flag = 1;
            for(int i = 0; i < 32; i++) {
                int bit =  n & flag;
                if(bit != 0) bits[i]++;
                flag <<= 1;
            }
        }

        // bits 统计好了，剩下就剩计算了
        int res = 0;
        for(int j = 31; j >= 0; j--) {
            res = res << 1;
            res += (bits[j] % 3);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1, 1, 6, 1}));
    }

}
