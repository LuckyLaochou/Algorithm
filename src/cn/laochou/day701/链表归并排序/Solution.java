package cn.laochou.day701.链表归并排序;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/2 0002 8:13
 * @Version: 1.0
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        // 递归结束条件
        if(head == null || head.next == null) {
            return head;
        }

        // 找到链表中间节点并断开链表 & 递归
        ListNode middle = middleNode(head);
        ListNode rightHead = middle.next;

        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 最后合并
        return mergeTwoLists(left, right);
    }




    private ListNode middleNode(ListNode head) {
        // 使用快慢指针来获取中间节点
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }


}


class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {this.val = val;}
}