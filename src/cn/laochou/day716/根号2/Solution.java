package cn.laochou.day716.根号2;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/16 0016 15:42
 * @Version: 1.0
 */
public class Solution {


    public float sqrtTwo(int k) {
        float left = 0;
        float right = k;
        while (left <= right) {
            float mid = left + (right - left) / 2;
            float mut = mid * mid;
            if(mut == k) {
                return mid;
            }
            if(mut > k) {
                right = mid;
            }
            if(mut < k) {
                left = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sqrtTwo(4));
        System.out.println(solution.sqrtTwo(3));
    }


}
