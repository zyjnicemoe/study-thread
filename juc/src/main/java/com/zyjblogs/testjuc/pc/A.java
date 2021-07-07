package com.zyjblogs.testjuc.pc;

/**
 * 线程之间通讯问题：生产者消费者问题
 * 线程相互交替执行  A B同时操作一个变量 num=0
 * A num+1
 * B num-1
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"B").start(); new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}
