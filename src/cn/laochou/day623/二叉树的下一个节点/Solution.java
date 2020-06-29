package cn.laochou.day623.二叉树的下一个节点;

public class Solution {

    /**
     * AC 代码
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode res;
        // 首先我们先判断当前节点是否有右子树
        if(pNode.right != null) {
            // 我们需要找到右子树的最左节点
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            res = pRight;
        }else {
            // 右子树为空
            // 获取父亲节点
            TreeLinkNode parent = pNode.next;
            TreeLinkNode current = pNode;
            // 如果父亲节点不为空，且是右子树。我们需要找到一个是父节点的左节点
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.next;
            }
            res = parent;
        }
        return res;
    }

}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    // 指向父亲的指针节点
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}