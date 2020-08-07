package cn.laochou.网易721笔试;

import java.util.*;
import java.util.logging.SocketHandler;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/21 0021 20:19
 * @Version: 1.0
 */
public class Four {

    public int splitPackage(String[] filename, String[][] relations) {
        List<List<String>> lists = new ArrayList<>();
        int res = 0;
        for (String[] relation : relations) {
            // 表示我们集合不包含任何关系
            // 看看我们的已经建立的依赖是否存在如果存在则不用考虑
            boolean shouldCon = true;
            List<String> contains = null;
            for (List<String> temp : lists) {
                if (temp.contains(relation[0])) {
                    shouldCon = false;
                    contains = temp;
                    break;
                }
            }
            if (shouldCon) {
                List<String> temp = new ArrayList<>();
                temp.add(relation[0]);
                temp.add(relation[1]);
                res++;
                lists.add(temp);
            } else {
                contains.add(relation[1]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.splitPackage(new String[]{"fileA", "fileB", "fileC", "fileD", "fileE"}, new String[][]{{"fileA", "fileB"}, {"fileB", "fileC"}, {"fileD", "fileE"}}));
        System.out.println(four.splitPackage(new String[]{"fileA", "fileC", "fileD"}, new String[][]{{"fileA", "fileC"}, {"fileD", "fileC"}}));
        System.out.println(four.splitPackage(new String[]{"fileA", "fileB", "fileD"}, new String[][]{{"fileA", "fileB"}, {"fileB", "fileD"}}));
    }

}
