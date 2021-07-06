package com.zyjblogs.testjuc.add;

import java.util.concurrent.CountDownLatch;

//计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6 必须要执行任务的时候在使用
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                // 数量 -1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //等待计数器归零然后向下执行
        countDownLatch.await();
        System.out.println("close door");
    }
}
