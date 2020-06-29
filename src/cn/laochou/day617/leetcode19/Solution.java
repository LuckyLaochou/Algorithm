package cn.laochou.day617.leetcode19;

public class Solution {

    /**
     * AC
     * 移除倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这个使用了哑节点防止空指针
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode first = ans;
        for(int i = 0; i <= n; i++) {
            if(first == null) {
                return null;
            }
            first = first.next;
        }
        ListNode second = ans;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return ans.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = solution.removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}
