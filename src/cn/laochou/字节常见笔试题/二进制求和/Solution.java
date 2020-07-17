package cn.laochou.字节常见笔试题.二进制求和;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 16:25
 * @Version: 1.0
 */
public class Solution {


    public String addBinary(String a, String b) {
        if(a == null || a.equals("")) return b;
        if(b == null || b.equals("")) return a;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int number1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int number2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int number = (number1 + number2 + carry) % 2;
            carry = (number1 + number2 + carry) / 2;
            stringBuilder.append(number);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }

}
