package cn.laochou.字节常见笔试题.三线程顺序打印;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 21:02
 * @Version: 1.0
 */
public class Solution {


    public static void main(String[] args) {
        Runnable work1 = new Work(0);
        Runnable work2 = new Work(1);
        Runnable work3 = new Work(2);
        Thread thread1 = new Thread(work1);
        Thread thread2 = new Thread(work2);
        Thread thread3 = new Thread(work3);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}


class Work implements Runnable {

    private static final Object lock = new Object();

    private static final int count = 4;

    private int value;

    private static int index = 1;

    @Override
    public void run() {
        for(int i = 1; i < count; i++) {
            synchronized (lock) {
                while (index % 3 != value) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + index);
                index++;
                lock.notifyAll();
            }
        }
    }


    public Work(int value) {
        this.value = value;
    }
}