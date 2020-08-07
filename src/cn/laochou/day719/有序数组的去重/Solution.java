package cn.laochou.day719.有序数组的去重;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/19 0019 20:41
 * @Version: 1.0
 */
public class Solution {


    //[1,1,2,2,3,3,4,4]
    public int[] removeMup(int[] numbers) {
        int left = 0;
        int right = 0;
        int ans = 1;
        while (right < numbers.length) {
            if(numbers[left] != numbers[right]) {
                numbers[++left] = numbers[right];
                ans++;
            }
            right++;
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(ans);
        return numbers;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeMup(new int[] {1, 1, 2, 2, 3, 3, 4, 4});
    }


}
