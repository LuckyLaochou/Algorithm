package cn.laochou.day630.生产者消费者模式;

import java.util.*;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 9:02
 * @Version: 1.0
 */
public class Solution {


    private static final Object lock = new Object();


    private static Queue<String> containers = new LinkedList<>();

    private static int SIZE = 10;


    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if(containers.size() >= SIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        containers.add(UUID.randomUUID().toString());
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if(containers.size() <= 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(containers.poll());
                    }
                    lock.notifyAll();
                }
            }
        });

        producer.start();
        consumer.start();
    }



}

