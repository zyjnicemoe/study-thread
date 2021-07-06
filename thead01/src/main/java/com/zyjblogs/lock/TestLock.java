package com.zyjblogs.lock;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {

    int ticketNums = 10;

    /**
     * 定义可重入锁
     */
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //加锁
            lock.lock();
            try {
                if (ticketNums <= 0) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println(ticketNums--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
