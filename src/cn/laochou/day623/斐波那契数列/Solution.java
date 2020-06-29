package cn.laochou.day623.斐波那契数列;

public class Solution {

    public int Fibonacci(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 1 || n == 0) {
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n - 2);
    }


    public int Fibonacci2(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int res = 0;
        int index = 3;
        while (index <= n) {
            res = a + b;
            b = a;
            a = res;
            index++;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci2(3));
        System.out.println(solution.Fibonacci2(5));
        System.out.println(solution.Fibonacci2(7));
    }

}
