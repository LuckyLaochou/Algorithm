package cn.laochou;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/31 0031 14:40
 * @Version: 1.0
 */
public class Test {

    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 50; i++) {
                number++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 50; i++) {
                number++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(number);

        int x = 4;
        System.out.println("value is " + ((x > 4) ? 99.9 : 9));
    }



    public int two(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int item : arr) {
            if(sum < 0) {
                sum = 0;
            }
            sum += item;
            max = Math.max(max, sum);
        }
        return max;
    }

}
