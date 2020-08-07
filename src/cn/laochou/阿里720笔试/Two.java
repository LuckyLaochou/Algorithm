package cn.laochou.阿里720笔试;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/20 0020 19:30
 * @Version: 1.0
 */
public class Two {


    public boolean getLucky(String number) {
        StringBuilder stringBuilder = new StringBuilder(number);
        while (stringBuilder.length() > 1) {
            StringBuilder temp = new StringBuilder();
            int length = stringBuilder.length();
            for(int i = 0; i < length - 1; i++) {
                temp.append(Math.abs(stringBuilder.charAt(i) - stringBuilder.charAt(i+1)));
            }
            stringBuilder = temp;
        }
        // 那么只剩最后一个
        return stringBuilder.charAt(0) == '7';
    }

    public int getLuckyNumber(int l, int r) {
        int res = 0;
        for(int i = l ; i <= r; i++) {
            if(getLucky(String.valueOf(i))) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Two two = new Two();
//        System.out.println(two.getLucky("219"));
//        System.out.println(two.getLucky("218"));

//        System.out.println(two.getLuckyNumber(1, 100));
        System.out.println(two.getLuckyNumber(1, 1000));
        System.out.println(two.getLuckyNumber(1, 100000));
    }

}
