package cn.laochou.字节常见笔试题.删除排序链表中的重复元素;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 21:32
 * @Version: 1.0
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null) {
            ListNode cur = head.next;
            while (cur != null && head.val == cur.val) {
                cur = cur.next;
            }
            head.next = cur;
            head = head.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode phead = solution.deleteDuplicates(head);
        while (phead != null) {
            System.out.println(phead.val);
            phead = phead.next;
        }
    }


}


class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {val = x;}
}