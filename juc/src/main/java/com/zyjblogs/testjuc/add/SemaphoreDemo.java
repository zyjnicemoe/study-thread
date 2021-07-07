package com.zyjblogs.testjuc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //线程数量 ：停车位  限流
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    /**
                     * acquire 得到
                     *信号量 -1
                     */
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放 信号量 +1
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
