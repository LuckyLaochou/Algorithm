package cn.laochou.day826.不使用减法做减法;

public class Solution {

    public int subtract(int a, int b) {
        while (b != 0) {
            int p = a & b;
            a ^= p;
            b ^= p;
            a |= b;
            b <<= 1;
        }
        return a;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subtract(4, 2));
    }

}
