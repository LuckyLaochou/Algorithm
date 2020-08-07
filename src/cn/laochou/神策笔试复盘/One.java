package cn.laochou.神策笔试复盘;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/5 0005 22:52
 * @Version: 1.0
 */
public class One {


    // 找出当前的中位数(使用最小堆算法)
    public static double getMiddle(int[] numbers) {
        int K = numbers.length / 2 + 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(K, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 0; i < numbers.length; i++) {
            if(queue.size() < K) {
                queue.add(numbers[i]);
            }else {
                if(numbers[i] > queue.peek()) {
                    queue.poll();
                    queue.add(numbers[i]);
                }
            }
        }
        if(numbers.length % 2 != 0) return (double)queue.peek();
        return (queue.poll() + queue.peek()) / 2.0;
    }


    public static void main(String[] args) {
        double number = getMiddle(new int[] {1, 2, 3, 4});
        System.out.println(number);
    }


}
