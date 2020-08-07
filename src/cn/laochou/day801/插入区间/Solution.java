package cn.laochou.day801.插入区间;

import java.util.*;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/1 0001 14:33
 * @Version: 1.0
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalLists = new ArrayList<>(Arrays.asList(intervals));
        intervalLists.add(newInterval);
        intervalLists.sort(Comparator.comparing(item -> item[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervalLists.get(0));
        for(int i = 1; i < intervalLists.size(); i++) {
            int[] item = intervalLists.get(i);
            int[] peek = res.get(res.size() - 1);
            if(item[0] > peek[1]) {
                res.add(item);
            }else {
                peek[1] = Math.max(item[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8});
        for(int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }


}
