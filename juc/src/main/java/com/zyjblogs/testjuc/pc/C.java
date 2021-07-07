package com.zyjblogs.testjuc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间通讯问题：生产者消费者问题
 * 线程相互交替执行  A B同时操作一个变量 num=0
 * A num+1
 * B num-1
 */
public class C {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printC();
            }
        }, "C").start();
    }
}

class Print {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private int number =1;
    public void printA() {
        lock.lock();
        try {
            while (number !=1) {
                //等待
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"===>AAAAA");
            //业务代码
            number =2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number !=2) {
                //等待
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"===>BBBB");
            //业务代码
            number =3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number !=3) {
                //等待
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"===>CCCC");
            //业务代码
            number =1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}