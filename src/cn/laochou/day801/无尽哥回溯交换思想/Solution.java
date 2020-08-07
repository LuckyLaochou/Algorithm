package cn.laochou.day801.无尽哥回溯交换思想;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/1 0001 16:31
 * @Version: 1.0
 */
public class Solution {

    public static int printAllPre(int[] str, int index, int cur, Map<Integer, Integer> map) {
        int k = 0;
        if(index == str.length) {
            System.out.println(cur);
            if(map.containsKey(cur)) {
                return 1;
            }else {
                if(cur % 7 == 0) {
                    map.put(cur, 1);
                    return 1;
                }
            }
        }else {
            for(int i = index; i < str.length; i++) {
                swap(str, index, i);
                k += printAllPre(str, index + 1, cur * 10 + str[index], map);
                swap(str, index, i);
            }
        }
        return k;
    }


    private static void swap(int[] str, int i, int j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2};
        Map<Integer, Integer> map = new HashMap<>();
        int res = printAllPre(arr, 0, 0, map);
        System.out.println(res);
    }

}
