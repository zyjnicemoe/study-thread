package com.zyjblogs.testjuc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS compareAndSet 比较并交换
 */
public class CASDemo1 {


    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(10, 1);

        new Thread(() -> {
            int stamp = atomicInteger.getStamp();
            System.out.println("A1=>" +stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Version
            System.out.println(atomicInteger.compareAndSet(10, 20, atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("A2=>"+atomicInteger.getStamp());
            System.out.println(atomicInteger.compareAndSet(20, 10, atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("A3=>"+atomicInteger.getStamp());
        }, "A").start();
        //乐观锁原理相同
        new Thread(() -> {
            int stamp = atomicInteger.getStamp();
            System.out.println("B1=>" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(10, 66, stamp, stamp + 1));
            System.out.println("B2=>"+atomicInteger.getStamp());
        }, "B").start();

    }
}
