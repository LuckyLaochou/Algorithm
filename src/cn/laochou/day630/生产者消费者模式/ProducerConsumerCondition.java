package cn.laochou.day630.生产者消费者模式;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ITLaochou
 * @Date: 2020/6/30 0030 9:34
 * @Version: 1.0
 */
public class ProducerConsumerCondition {


    private static ReentrantLock lock = new ReentrantLock();

    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();


    private static Queue<String> queue = new LinkedList<>();


    private static final int SIZE = 10;


    public static void main(String[] args) {


        Runnable producer = () -> {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() >= SIZE) {
                        full.await();
                    }
                    queue.add(UUID.randomUUID().toString());
                    empty.signalAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread producerA = new Thread(producer);


        Runnable consumer = () -> {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() <= 0) {
                        empty.await();
                    }
                    System.out.println(queue.poll());
                    full.signalAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread consumerA = new Thread(consumer);
        Thread consumerB = new Thread(consumer);

        producerA.start();

        consumerA.start();
        consumerB.start();
    }


}


class Storage {




}
