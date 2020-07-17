package cn.laochou.day703.分隔链表;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 8:50
 * @Version: 1.0
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode phead = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode ahead = afterHead;
        while (head != null) {
            if(head.val < x) {
                beforeHead.next = head;
                beforeHead = beforeHead.next;
            }else {
                afterHead.next = head;
                afterHead = afterHead.next;
            }
            head = head.next;
        }
        // 避免死链
        afterHead.next = null;
        beforeHead.next = ahead.next;
        return phead.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next. next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode phead = solution.partition(head, 3);
        while(phead != null) {
            System.out.println(phead.val);
            phead = phead.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}
