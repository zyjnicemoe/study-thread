package com.zyjblogs.testjuc.tvolatile;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
    //volatile 让num可见
    /**
     * volatile
     * 1、保证可见性
     * 2、不保证原子性
     * 3、静止指令重排
     */
    private volatile static int num =0;
    public static void main(String[] args) {

        //线程A
        new Thread(()-> {
            while (num==0) {

            }
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);
    }
}
