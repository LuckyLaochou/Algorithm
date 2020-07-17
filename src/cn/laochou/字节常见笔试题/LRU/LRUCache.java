package cn.laochou.字节常见笔试题.LRU;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 15:47
 * @Version: 1.0
 */
public class LRUCache {


    private Node head, tail;
    private int size;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addFirst(Node x) {
        x.next = head.next;
        x.pre = head;
        head.next.pre = x;
        head.next = x;
        size++;
    }

    public void remove(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    public Node removeLast() {
        if(tail.pre == head) {
            return null;
        }
        Node last = tail.pre;
        remove(last);
        return last;
    }



    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }

}


class Node {
    int key;
    int val;
    Node next, pre;
    Node(int k, int v) {this.key = k; this.val = v;}
}
