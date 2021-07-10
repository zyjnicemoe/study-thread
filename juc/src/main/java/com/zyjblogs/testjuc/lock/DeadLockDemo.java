package com.zyjblogs.testjuc.lock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        /**
         * 若无法使用jps -l查看信息就是代表着 没有权限  ，需要到temp目录下找到hsperfdata_用户名文件，修改权限即可
         * System.out.println(System.getProperties());
         *
         *
         * jsp -l查看进程号
         * jstack 进程号 查看 信息
         */

        String lockA ="lockA";
        String lockB ="lockB";
        new Thread(new MyThread(lockA,lockB),"A").start();
        new Thread(new MyThread(lockB,lockA),"B").start();
    }
}

class MyThread implements Runnable {

    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " lock:" + lockA + "=> get :" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " lock:" + lockB + "=> get :" + lockA);
            }
        }
    }
}