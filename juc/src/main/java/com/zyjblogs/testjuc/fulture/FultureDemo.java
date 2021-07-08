package com.zyjblogs.testjuc.fulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture
 */
public class FultureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求 没有返回值的异步回调
//        Future<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(Thread.currentThread().getName() + " runAsync-> Void");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println("main");
//        future.get();
        /**
         * 有返回值的异步回调
         *
         */
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " supplyAsync-> Integer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i =1/0;
            return 1024;
        });
        System.out.println(future.whenComplete((t, u) -> {
            System.out.println("t=" + t + ": u=" + u);
        }).exceptionally((e) -> {
            //可以回去到错误的返回结果
            System.out.println(e.getMessage());
            return 233;
        }).get());
    }
}
