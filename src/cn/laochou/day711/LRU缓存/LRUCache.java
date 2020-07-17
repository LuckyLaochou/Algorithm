package cn.laochou.day711.LRU缓存;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/11 0011 16:36
 * @Version: 1.0
 */
public class LRUCache {
    private Map<Integer, LinkedNode> cache = new HashMap<Integer, LinkedNode>();
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        // 如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if(node == null) {
            // 如果key所对应的对象不存在，创建一个新的节点
            LinkedNode newNode = new LinkedNode(key, value);
            // 加入hash表
            cache.put(key, newNode);
            // 添加到头部
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            // 如果超出了容量
            if(cache.size() > capacity) {
                // 删除tail对应的节点
                LinkedNode deleted = tail.prev;
                deleted.prev.next = deleted.next;
                deleted.next.prev = deleted.prev;
                cache.remove(deleted.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }
    private void moveToHead(LinkedNode node) {
        // 首先先清除
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 然后加入到头部
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


}


class LinkedNode {
    int key;
    int value;
    LinkedNode prev;
    LinkedNode next;
    public LinkedNode() {}
    public LinkedNode(int key, int val) {this.key = key; this.value = val; }
}
