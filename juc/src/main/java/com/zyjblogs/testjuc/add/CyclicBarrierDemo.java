package com.zyjblogs.testjuc.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐七颗龙珠了");
        });
        for (int i =1; i<= 7; i++) {
            final int temp = i;
            //lambda能拿到i吗
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集已经了"+temp+"颗龙珠");
                try {
                    //等待
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
