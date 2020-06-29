package cn.laochou.day625.数字的整数次方;

public class Solution {

    /**
     * 卡在最后一个 用例 Integer.MIN_VALUE
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n > 0) {
            return pow(x, n);
        }else {
            return 1 / pow(x, Math.abs(n));
        }
    }

    private double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double half = pow(x, n / 2);
        // 奇数
        if(n % 2 == 1) {
            return x * half * half;
        }else {
            return half * half;
        }
    }


    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.myPow(0.00001
                , 2147483647));
    }

}
