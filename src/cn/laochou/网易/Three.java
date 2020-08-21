package cn.laochou.网易;

import java.util.Scanner;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/8 0008 18:26
 * @Version: 1.0
 */
public class Three {

    static int min = Integer.MAX_VALUE;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            min = Integer.MAX_VALUE;
            sum = 0;
            for(int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
                sum += numbers[i];
            }
            helper(numbers, 0, 0, 0);
            System.out.println(min);
        }
    }


    static void helper(int[] numbers, int index, int ans1, int ans2) {
        if(index == numbers.length) {
            if(ans1 == ans2) {
                min = Math.min(min, sum - 2 * ans1);
            }
            return;
        }

        int val = numbers[index];
        // 丢弃
        helper(numbers, index + 1, ans1, ans2);
        // 给第一位同学
        helper(numbers, index + 1, ans1 + val, ans2);
        // 给第二位同学
        helper(numbers, index + 1, ans1, ans2 + val);
    }

}
