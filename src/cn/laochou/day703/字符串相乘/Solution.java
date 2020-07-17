package cn.laochou.day703.字符串相乘;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 17:06
 * @Version: 1.0
 */
public class Solution {


    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        for(int i = num2.length() - 1; i  >= 0; i--) {
            int carry = 0;
            int number2 = num2.charAt(i) - '0';
            // 用来保存乘积的值
            StringBuilder temp = new StringBuilder();
            // 需要补0
            for(int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            // 然后就是与我们的num1的每一位进行乘积
            for(int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int number1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int val = (number1 * number2 + carry) % 10;
                carry = (number1 * number2 + carry) / 10;
                temp.append(val);
            }
            res = addString(res, temp.reverse().toString());
        }
        return res;
    }


    public String addString(String num1, String num2) {
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while (length1 >= 0 || length2 >= 0 || carry != 0) {
            int number1 = length1 < 0 ? 0 : num1.charAt(length1) - '0';
            int number2 = length2 < 0 ? 0 : num2.charAt(length2) - '0';
            int number = (number1 + number2 + carry) % 10;
            carry = (number1 + number2 + carry) / 10;
            stringBuilder.append(number);
            length1--;
            length2--;
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("9", "9"));
    }


}
