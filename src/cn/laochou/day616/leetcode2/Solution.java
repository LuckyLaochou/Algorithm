package cn.laochou.day616.leetcode2;

public class Solution {

    /**
     * AC
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 这里其实主要注意一个进位的问题
        int cos = 0;
        int number1;
        int number2;
        int number;
        ListNode head = new ListNode(-1);
        ListNode result = head;
        while (l1 != null || l2 != null || cos != 0) {
            number1 = l1 != null ? l1.val : 0;
            number2 = l2 != null ? l2.val : 0;
            number = (number1 + number2 + cos) % 10;
            head.next = new ListNode(number);
            head = head.next;
            cos = (number1 + number2 + cos) / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return result.next;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
