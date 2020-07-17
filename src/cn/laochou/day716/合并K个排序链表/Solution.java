package cn.laochou.day716.合并K个排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/16 0016 11:02
 * @Version: 1.0
 */
public class Solution {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int K = lists.length;
        if(K == 1) return lists[0];
        // 我们通过一个优先级来搞
        // 使用最小堆，因为我们每次都要搞一个最小的.
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(K, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // init
        for(int i = 0; i < K; i++) {
            priorityQueue.add(lists[i]);
        }
        // 使用一个哑节点
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            cur.next = temp;
            cur = cur.next;
            if(temp.next != null) priorityQueue.add(temp.next);
        }

        return ans.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);
        ListNode[] lists = new ListNode[] {head1, head2};
        ListNode ans = solution.mergeKLists(lists);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
