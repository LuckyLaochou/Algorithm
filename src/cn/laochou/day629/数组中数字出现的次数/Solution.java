package cn.laochou.day629.数组中数字出现的次数;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/29 0029 17:24
 * @Version: 1.0
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int temp = 0;
        for(int i : nums) {
            temp ^= i;
        }
        int first = 0;
        int second = 0;
        int flag = 1;
        // 异或：同为0，异为1. 与：1 & 0 = 0 ，1 & 1 = 1 ，0 & 0 = 0 或 1 | 0 = 1，1 | 1 = 1
        while ((temp & flag) == 0) {
            flag = flag << 1;
        }
        for(int i : nums) {
            if((flag & i) == 0) {
                first ^= i;
            }else {
                second ^= i;
            }
        }
        res[0] = first;
        res[1] = second;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumbers(new int[]{4, 1, 4, 6})));
    }


}
