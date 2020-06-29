package cn.laochou.day627.复杂链表的复制;

public class Solution {

    public Node copyRandomList(Node head) {
        // 三步走
        // 1. 首先复制原节点
        cloneNodes(head);
        // 2. 复制随机节点
        cloneRandom(head);
        // 3. 改动指向
        return reconnect(head);
    }



    private void cloneNodes(Node head) {
        while (head != null) {
            Node n = new Node(head.val);
            n.next = head.next;
            head.next = n;
            head = n.next;
        }
    }


    private void cloneRandom(Node head) {
        while (head != null) {
            Node clone = head.next;
            if(head.random != null) {
                // head.random.next : 指向副本
                clone.random = head.random.next;
            }
            head = clone.next;
        }
    }


    private Node reconnect(Node head) {
        Node cloneHead = null;
        Node cloneNode = null;
        if(head != null) {
            cloneHead = head.next;
            cloneNode = head.next;
            head.next = cloneHead.next;
            head = head.next;
        }
        while (head != null) {
            cloneNode.next = head.next;
            cloneNode = cloneNode.next;
            head.next = cloneNode.next;
            head = head.next;
        }
        return cloneHead;
    }

}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
