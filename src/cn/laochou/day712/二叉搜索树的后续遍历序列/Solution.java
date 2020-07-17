package cn.laochou.day712.二叉搜索树的后续遍历序列;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/12 0012 23:04
 * @Version: 1.0
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        // 我们通过递归的方式来进行一个判断
        // 首先我们需要知道一些特性，后序遍历的最后一个元素就是根节点了。后面左子树的元素都比根节点小，右子树的元素都比根节点大
        return recursion(postorder, 0, postorder.length - 1);
    }


    private boolean recursion(int[] postorder, int left, int right) {
        if(left > right) {
            return true;
        }
        int p = left;
        // 左子树，比根节点小
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int mid = p;
        // 右子树，比根节点大
        while (postorder[p] > postorder[right]) {
            p++;
        }
        return p == right && (recursion(postorder, left, mid - 1) && recursion(postorder, mid, right - 1));
    }

}
