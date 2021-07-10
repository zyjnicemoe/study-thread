package com.zyjblogs.testjuc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS compareAndSet 比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        /**
         * 期望、更新
         * public final boolean compareAndSet(int expect, int update)
         * 如果期望的值达到了，就更新否则就不更新
         * CAS 是CPU并发原语
         */
        //捣乱的线程
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());
        //期望的线程
        System.out.println(atomicInteger.compareAndSet(2020, 2022));
        System.out.println(atomicInteger.get());
    }
}
