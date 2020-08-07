package cn.laochou.阿里724笔试;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/24 0024 21:57
 * @Version: 1.0
 */
public class One {


    public long eatMoreCake(long[] cakes) {
        // 我们需要找到最小的小标
        int min = 0;
        for(int i = 0; i < cakes.length; i++) {
            if(cakes[i] <= cakes[min]) {
                min = i;
            }
            if(cakes[i] == 0) break;
        }
        // 最小的值
        long minTarget = cakes[min];
        long res = 0;
        int left = 0;
        int right = min;
        int leftMin = 0;
        while (left <= min - 1) {
            if(cakes[left] <= cakes[leftMin]) {
                leftMin = left;
            }
            left++;
        }
        res += cakes[leftMin] * min;
        while (right < cakes.length) {
            if(cakes[right] >= minTarget) {
                res += minTarget;
            }else {
                break;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {


        Random random = new Random();

        long[][] arrs = new long[1000][10];
        for(int i = 0; i < 1000; i++) {
            for(int j = 1; j < 5; j++) {
                arrs[i][j] = random.nextInt(20);
            }
        }

        int success = 0;
        int failed = 0;

        for(int k = 0; k < arrs.length; k++) {
            long[] arr = arrs[k];
            One one = new One();
            long myAns = one.eatMoreCake(arrs[k]);

            int min = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[min] >= arr[i])
                    min = i;
            }
            long cur = process(arr, min - 1, arr.length);
            cur += arr[min] * arr.length;
            if(cur == myAns) {
                success++;
            }else {
                failed++;
            }
            System.out.println(cur == myAns);
        }

        System.out.println("成功：" + success);
        System.out.println("失败：" + failed);

    }

    public static long process(long[] arr, int min, int n) {
        if (min == -1) {
            return 0;
        }
        long res = 0;
        int cur = 0;
        for (int i = 0; i <= min; i++) {
            if (arr[cur] >= arr[i])
                cur = i;
        }
        if (arr[cur] > arr[min+1]) {
            res += (min + 1) * (arr[cur] - arr[min + 1]);
            for(int i = 0; i <= cur; i++)
                arr[i] -= (arr[cur] - arr[min + 1]);
        }
        res += process(arr, cur - 1, n);
        return res;
    }


}
