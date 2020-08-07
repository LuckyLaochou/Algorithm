package cn.laochou.网易721笔试;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/21 0021 19:38
 * @Version: 1.0
 */
public class Three {

    public int determineVirusType(int size, int[][] swapIndexs) {
        int[] numbers = new int[size];
        int count = size;
        for(int i = 1; i <= size; i++) {
            numbers[i-1] = count--;
        }
        // 我们要对numbers进行处理
        for(int[] item : swapIndexs) {
            int temp = numbers[item[0]];
            numbers[item[0]] = numbers[item[1]];
            numbers[item[1]] = temp;
        }
        // 就是我们的偏序列了.
        // 我们需要计算当前的位置有多少个不同的就OK了
        int res = 0;
        for(int i = 0; i < size; i++) {
            int cur = numbers[i];
            for(int j = i + 1; j < size; j++) {
                if(numbers[j] > cur) {
                    res++;
                }
            }
        }
        return res % 2 == 0 ? 2 : 1;
    }


    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.determineVirusType(5, new int[][]{{2, 4}, {1, 4}, {0, 3}, {0, 3}}));
    }

}
