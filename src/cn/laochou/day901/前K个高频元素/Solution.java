package cn.laochou.day901.前K个高频元素;

import java.util.*;

public class Solution {

    /**
     * AC
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.times - o2.times;
            }
        });
        HashMap<Integer, Node> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                Node temp = map.get(num);
                temp.times++;
            }else {
                map.put(num, new Node(num, 1));
            }
        }
        for(Map.Entry<Integer, Node> entry : map.entrySet()) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(entry.getValue());
            }else {
                Node temp = priorityQueue.peek();
                if(temp.times < entry.getValue().times) {
                    priorityQueue.poll();
                    priorityQueue.add(entry.getValue());
                }
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            ans[index++] = priorityQueue.poll().value;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ans));
    }

}


class Node {
    int value;
    int times;
    public Node(int value, int times) {
        this.value = value;
        this.times = times;
    }

}