package com.zyjblogs.testjuc.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    //Thread 默认null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "===> mylock");
        while (!atomicReference.compareAndSet(null, thread)) {

        };
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "===> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }
}
