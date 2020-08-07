package cn.laochou.test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 10:02
 * @Version: 1.0
 */
public class Solution {


    private String name = "tomn";

    public boolean validString(String s) {
        boolean size = s.length() >= 16;
        String regex = "^[a-z-A-Z]+$";
        boolean match = s.matches(regex);
        boolean last = s.contains("-");
        return size & match & last;
    }



    public int getAllWords(String str) {
        int word=0;
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(!(c>='a'&&c<='z' || c>='A'&&c<='Z')) {
                word++;
            }
        }
        return word;
    }






    public static void main(String[] args) {
    }


}
