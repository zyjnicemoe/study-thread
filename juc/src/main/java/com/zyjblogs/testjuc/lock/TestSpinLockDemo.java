package com.zyjblogs.testjuc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestSpinLockDemo {
    public static void main(String[] args) {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();

        SpinLockDemo lockDemo = new SpinLockDemo();

        new Thread(() -> {
            try {
                lockDemo.myLock();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockDemo.myUnLock();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                lockDemo.myLock();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockDemo.myUnLock();
            }
        }, "B").start();
    }
}
