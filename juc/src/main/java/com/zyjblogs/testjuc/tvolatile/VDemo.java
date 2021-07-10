package com.zyjblogs.testjuc.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不保证原子性
 */
public class VDemo {

    //volatile 不保证原子性
    private static volatile AtomicInteger num = new AtomicInteger();
    public  static void add() {
        //num++ 不是原子性操作
        //num加一  CAS
        num.getAndDecrement();
    }

    public static void main(String[] args) {
        /**
         * 理论值为20000
         *
         */
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        // main gc
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
