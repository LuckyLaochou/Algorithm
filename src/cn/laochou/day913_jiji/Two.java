package cn.laochou.day913_jiji;

import java.util.Scanner;

public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            System.out.println(getOrigin(line, n));
        }
    }
    public static String getOrigin(String password, int n) {
        char[] cs = password.toCharArray();
        int index = 0;
        while (index < password.length()) {
            if(index + n < password.length()) {
                reverse(index, index + n - 1, cs);
                index = index + n;
            }else {
                reverse(index, password.length() - 1, cs);
                break;
            }
        }
        return new String(cs);
    }
    private static void reverse(int start, int end, char[] cs) {
        if(end >= cs.length) end = cs.length - 1;
        while (start < end) {
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }
    }

}
