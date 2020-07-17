package cn.laochou.字节常见笔试题.K个一组翻转链表;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 19:07
 * @Version: 1.0
 */
public class Solution {

    /**
     * 手撕通过
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        // 使用哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            // 我们需要先判断当前是否有K个节点
            int i = 1;
            ListNode temp = head;
            boolean isK = true;
            while (i < k) {
                temp = temp.next;
                // 说明没有K个节点
                if(temp == null) {
                    isK = false;
                    break;
                }
                i++;
            }
            if(isK) {
                // 如果有K个节点，那么就需要翻转了
                int j = 1;
                while (j < k) {
                    ListNode after = head.next;
                    ListNode end = after.next;
                    after.next = pre.next;
                    pre.next = after;
                    head.next = end;
                    j++;
                }
                pre = head;
                head = head.next;
            }else {
                break;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode phead = solution.reverseKGroup(head, 3);
        while (phead != null) {
            System.out.println(phead.val);
            phead = phead.next;
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
