package cn.laochou.阿里720笔试;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/20 0020 19:05
 * @Version: 1.0
 */
public class One {

    public int getAnswer(int n, int k) {
        for(int i = 1; i < n; i++) {
            int tempMax = n - i;
            for(int j = i + 1; j <= tempMax; j++) {
                int three = tempMax - j;
                if(getGcd(i, j) == k && getGcd(i, three) == k && getGcd(j, three) == k) {
                    System.out.println(i + " " + j + " " + three);
                    return 0;
                }
            }
        }
        System.out.println(-1);
        return -1;
    }


    public int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a % b);
    }


    public static void main(String[] args) {
        One one = new One();
        one.getAnswer(6, 1);
        one.getAnswer(12, 4);
        one.getAnswer(38, 2);
    }

}
