package cn.laochou.day630.反转链表2;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 13:21
 * @Version: 1.0
 */
public class Solution {


    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        int count = 1;
        ListNode phead = head;
        while (phead != null) {
            phead = phead.next;
            count++;
        }
        if(m >= count) {
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode cur = dumy.next;
        count = 0;
        while (count < n) {
            if(count == m) {
                while (count < n) {
                    ListNode after = cur.next;
                    ListNode end = after.next;
                    after.next = pre.next;
                    pre.next = after;
                    cur.next = end;
                    count++;
                }
                break;
            }
            pre = pre.next;
            cur = cur.next;
            count++;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.reverseBetween(head, 2, 4);
    }


}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}