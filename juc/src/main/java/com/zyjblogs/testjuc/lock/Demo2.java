package com.zyjblogs.testjuc.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized
 */
public class Demo2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();

        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }
}

class Phone2 {
    Lock lock = new ReentrantLock();
    public void sms() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " sms");
            //这里也有锁
            call();
        }finally {
            lock.unlock();
        }
    }

    public synchronized void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " call");
        }finally {
            lock.unlock();
        }

    }
}
