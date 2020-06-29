package cn.laochou.day627.链表中环的入口节点;

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 首先我们需要判断我们的链表中是否存在环
        ListNode meeting = existLoop(pHead);
        if(meeting != null) {
            // 统计我们环中拥有的元素
            int count = 1;
            ListNode pNode = meeting;
            while (pNode.next != meeting) {
                count++;
                pNode = pNode.next;
            }
            // 定义两个快慢指针
            ListNode pFast = pHead;
            ListNode pSlow = pHead;
            int index = 0;
            // 先走N步
            while (index < count) {
                pFast = pFast.next;
                index++;
            }
            // 然后一起走
            while (pFast != pSlow) {
                pFast = pFast.next;
                pSlow = pSlow.next;
            }
            return pFast;
        }
        return null;
    }



    private ListNode existLoop(ListNode pHead) {
        // 使用快慢指针来判断是否有环
        if(pHead == null) {
            return null;
        }
        ListNode pSlow = pHead.next;
        // 表示只有一个节点
        if(pSlow == null) {
            return null;
        }
        ListNode pFast = pSlow.next;
        while (pSlow != null && pFast != null) {
            // 如果有相同的节点
            if(pSlow == pFast) {
                return pSlow;
            }
            pSlow = pSlow.next;
            if(pFast.next != null) {
                pFast = pFast.next.next;
            }
        }
        return null;
    }


}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
