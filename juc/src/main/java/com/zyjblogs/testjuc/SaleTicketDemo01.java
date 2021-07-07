package com.zyjblogs.testjuc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 正在得到多线程开发
 * 线程就是一个单独的资源类，没有任何附属操作
 * 1.属性 方法
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}

class Ticket {
    private int number = 50;
    Lock lock = new ReentrantLock();
//    public synchronized void sale() {
//        if (number >0) {
//            System.out.println(Thread.currentThread().getName()+"卖出了几张票"+number--+"剩余"+number);
//        }
//    }
    public void sale() {
        //加锁
        lock.lock();
        //尝试获取锁
//        lock.tryLock();
        try{
            //业务代码
            if (number >0) {
                System.out.println(Thread.currentThread().getName()+"卖出了几张票"+number--+"剩余"+number);
            }
        }finally {
            //解锁
            lock.unlock();
        }
    }
}
