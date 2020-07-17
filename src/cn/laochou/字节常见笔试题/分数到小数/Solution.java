package cn.laochou.字节常见笔试题.分数到小数;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/7 0007 11:19
 * @Version: 1.0
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        // 从除数是0，那么肯定返回"0"
        if(numerator == 0)  return "0";
        StringBuilder fraction = new StringBuilder();
        if(numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend/divisor);
        // 余数
        long remainder = dividend % divisor;
        if(remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if(map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }

}
