package cn.laochou.day706.合并K个排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/6 0006 22:25
 * @Version: 1.0
 */
public class Solution {

    /**
     * 通过优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        // o1 是入队元素, o2 是父节点。
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val < o2.val ? -1 : 1);

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for(ListNode node : lists) {
            if(node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if(p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
