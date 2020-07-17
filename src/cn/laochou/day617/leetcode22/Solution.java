package cn.laochou.day617.leetcode22;

public class Solution {


    /**
     * 需要倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ans = head;
        // 注意， 0-k-1 就是走了 k 步
        for(int i = 0; i < k; i++) {
            if(head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            ans = ans.next;
        }
        return ans;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}