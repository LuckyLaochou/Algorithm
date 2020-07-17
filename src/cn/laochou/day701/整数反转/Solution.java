package cn.laochou.day701.整数反转;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 18:30
 * @Version: 1.0
 */
public class Solution {


    public int reverse(int x) {
        String str = String.valueOf(x);
        if(x < 0) {
            str = str.substring(1);
            StringBuilder stringBuilder = new StringBuilder(str);
            long number = Long.parseLong(stringBuilder.reverse().toString());
            if(number * -1 < Integer.MIN_VALUE) {
                return 0;
            }
            return (int)number * -1;
        }else {
            StringBuilder stringBuilder = new StringBuilder(str);
            long number = Long.parseLong(stringBuilder.reverse().toString());
            if(number > Integer.MAX_VALUE) {
                return 0;
            }
            return (int)number;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(Integer.MIN_VALUE));
        System.out.println(solution.reverse(Integer.MAX_VALUE));
    }

}
