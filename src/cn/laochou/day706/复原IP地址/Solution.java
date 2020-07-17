package cn.laochou.day706.复原IP地址;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/6 0006 10:47
 * @Version: 1.0
 */
public class Solution {

    private List<String> results;
    private StringBuilder stringBuilder;
    private char[] chars;

    public List<String> restoreIpAddress(String s) {
        results = new ArrayList<>();
        stringBuilder = new StringBuilder();
        chars = s.toCharArray();
        dfs(0, 0);
        return results;
    }


    /**
     * 回溯查找可能的ip数字
     * @param count 当前已经确定的数字
     * @param i 下一个待处理的字符下标
     */
    private void dfs(int count, int i) {
        // 找到了4个数字，且字符刚好用完了，标着我们找到了一个解。
        if(count == 4 && i == chars.length) {
            results.add(stringBuilder.toString());
            return;
        }

        int remainCount = 4 - count;
        int remainChars = chars.length - 1;

        // 判断剩余的字符是否有解
        if(remainCount > remainChars || remainCount * 3 < remainChars) {
            return;
        }

        int len = stringBuilder.length();

        // 不允许出现以0开头的多位数
        int maxLen = chars[i] == '0' ? 1 : 3;
        for(int j = 0; j < maxLen && i + j < chars.length; j++) {
            // 取三位数时，需要判断是否超出255
            if(j == 2 && (chars[i] - '0') * 100 + (chars[i+1] - '0') * 10 + (chars[i+2] - '0') > 255) {
                continue;
            }
            for(int k = 0; k <= j; k++) {
                stringBuilder.append(chars[i + k]);
            }

            // 第四个数后面不需要加.
            if(count < 3) {
                stringBuilder.append(".");
            }
            dfs(count+1, i + j + 1);
            // 因为第四个数字后面不需要加.,回溯时少删除一位
            stringBuilder.delete(len, count < 3 ? len + j + 2 : len + j + 1);
        }

    }
}
