package cn.laochou.字节常见笔试题.序列化二叉树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 14:57
 * @Version: 1.0
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if(root == null) {
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
        // 层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        stringBuilder.append("[");
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                root = queue.poll();
                if(root != null) {
                    stringBuilder.append(root.val).append(",");
                    queue.add(root.left);
                    queue.add(root.right);
                }else {
                    stringBuilder.append("null").append(",");
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String str = data.substring(1, data.length() - 1);
        String[] datas = str.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!datas[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(datas[i]));
                queue.add(node.left);
            }
            i++;
            if(!datas[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(datas[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        Codec solution = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(solution.serialize(root));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int v) {this.val = v;}
}
