package cn.laochou.字节常见笔试题.扑克牌中的顺子;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 9:56
 * @Version: 1.0
 */
public class Solution {


    public boolean isStraight(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        // 如果是顺子的话，那么从max-5~max 必须连续
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 5; i++) {
            set.add(max - 4 + i);
        }
        int less = 0;
        int count = 0;
        for(int item : nums) {
            if(!set.contains(item)) {
                less++;
            }else {
                set.remove(item);
            }
            if(item == 0) {
                count++;
            }
        }
        return less == 0 || less == count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isStraight(new int[]{0, 0, 2, 2, 5}));
    }

}
