package cn.laochou.day701.链表的排序;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/1 0001 23:54
 * @Version: 1.0
 */
public class Solution {

    public Node sortList(Node head) {
        int temp;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            while (next != null) {
                if(next.val < cur.val) {
                    temp = next.val;
                    next.val = cur.val;
                    cur.val = temp;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

}


class Node {
    int val;
    Node next;
    public Node(int val) {this.val = val;}
}