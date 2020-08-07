package cn.laochou.字节常见笔试题.反转链表;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 21:48
 * @Version: 1.0
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        while(head != null) {
            ListNode after = head.next;
            head.next = pre;
            pre = head;
            head = after;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {this.val = val;}
}
