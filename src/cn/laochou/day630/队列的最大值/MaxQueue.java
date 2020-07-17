package cn.laochou.day630.队列的最大值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 15:05
 * @Version: 1.0
 */
public class MaxQueue {

    private Queue<Integer> queue;

    private LinkedList<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if(!maxQueue.isEmpty()) return maxQueue.getFirst();
        return -1;
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.peek() < value) {
           maxQueue.removeLast();
        }
        maxQueue.add(value);
    }

    public int pop_front() {
        if(!queue.isEmpty()) {
            int val = queue.poll();
            if (!maxQueue.isEmpty() && val == maxQueue.peek()) {
                maxQueue.removeFirst();
            }
            return val;
        }
        return -1;
    }


}
