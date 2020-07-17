package cn.laochou.day701.不用加减乘除做加法;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 10:35
 * @Version: 1.0
 */
public class Solution {

    public int add(int num1, int num2) {
        int carry;
        while (num2 != 0) {
            carry = (num1 & num2) << 1;
            num1 = num1 ^ num2;
            num2 = carry;
        }

        return num1;
    }


}
