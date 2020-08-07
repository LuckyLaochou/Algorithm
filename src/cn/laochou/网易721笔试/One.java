package cn.laochou.网易721笔试;

import cn.laochou.day617.leetcode19.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/21 0021 19:14
 * @Version: 1.0
 */
public class One {

    public int[][] invertTree(int[][] nodeDataList) {
        List<int[]> res = new ArrayList<>();
        int length = nodeDataList.length;
        // 以递归的形式进行一个处理
        dfs(res, nodeDataList, 0);
        return res.toArray(new int[length][2]);
    }


    private void dfs(List<int[]> res, int[][] nodeDataList, int parent) {
        // 先找到当前父节点的子节点
        List<int[]> childs = new ArrayList<>();
        for(int[] item : nodeDataList) {
            if(item[1] == parent) {
                childs.add(item);
            }
        }
        // 没有子节点的时候
        if(childs.size() == 0) return;
        // 如果有子节点的时候，反向加入
        for(int i = childs.size() - 1; i >= 0; i--) {
            res.add(childs.get(i));
        }
        // 这个时候需要反向遍历
        for(int i = childs.size() - 1; i >= 0; i--) {
            dfs(res, nodeDataList, childs.get(i)[0]);
        }
    }


    public static void main(String[] args) {
        One one = new One();
        int[][] ans = one.invertTree(new int[][] {{1, 0}, {2, 1}, {5, 2}, {6, 5}, {7, 5}, {3, 1}, {4, 1}});
        for(int[] item : ans) {
            System.out.print("[" + item[0] + " " + item[1] + "]");
        }
    }

}
