package cn.laochou.字节常见笔试题.三数之和;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 19:32
 * @Version: 1.0
 */
public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            // 去重
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if(sum > 0) {
                    right--;
                }
                if(sum < 0) {
                    left++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        for(List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
