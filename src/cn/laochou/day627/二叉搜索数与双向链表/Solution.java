package cn.laochou.day627.二叉搜索数与双向链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public Node treeToDoublyList(Node root) {
       return null;
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
