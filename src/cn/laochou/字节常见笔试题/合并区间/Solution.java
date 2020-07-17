package cn.laochou.字节常见笔试题.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 22:02
 * @Version: 1.0
 */
public class Solution {


    /**
     * 这个就是判断如何进行一个合并呗，判断是否有覆盖空间而已
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return new int[][] {};
        int len = intervals.length;
        if(len < 2) return intervals;
        // 按照左起点排序
        Arrays.sort(intervals, Comparator.comparing(item -> item[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i = 1; i < len; i++) {
            int[] curIntervals = intervals[i];
            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾断点进行比较
            int[] peek = res.get(res.size() - 1);
            if(curIntervals[0] > peek[1]) {
                res.add(curIntervals);
            }else {
                peek[1] = Math.max(curIntervals[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
