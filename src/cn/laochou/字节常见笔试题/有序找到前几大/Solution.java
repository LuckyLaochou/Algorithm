package cn.laochou.字节常见笔试题.有序找到前几大;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/8 0008 16:49
 * @Version: 1.0
 */
public class Solution {

    public int getTheKMaxNumber(int k, int[] numbers) {
        // 建立一个最小堆
        PriorityQueue<NumberCount> priorityQueue = new PriorityQueue<>(k, new Comparator<NumberCount>() {
            @Override
            public int compare(NumberCount o1, NumberCount o2) {
                return o1.count - o2.count;
            }
        });
        int index = 0;
        while (index < numbers.length) {
            int start = index;
            int end = index;
            while (end < numbers.length && numbers[end] == numbers[start]) {
                end++;
            }
            if(priorityQueue.size() < k) {
                priorityQueue.add(new NumberCount(numbers[index], end - start));
            }else {
                if(end - start > priorityQueue.peek().count) {
                    priorityQueue.poll();
                    priorityQueue.add(new NumberCount(numbers[index], end - start));
                }
            }
            index = end;
        }
        priorityQueue.forEach(System.out::println);
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getTheKMaxNumber(2, new int[] {1,1,2,2,2,3,3,3,3});
    }

}

class NumberCount {
    int val;
    int count;

    NumberCount(int val, int count) {this.val = val; this.count = count;}

    @Override
    public String toString() {
        return "val : " + val + " count : " + count;
    }
}