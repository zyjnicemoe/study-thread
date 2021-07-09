package com.zyjblogs.testjuc.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 *
 * @author zhuyijun
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * zhuyijun         2021/7/8 10:06               1.0                         线程池
 * @program study-thread
 * @description 线程池
 * @create 2021/7/8 10:06
 */
//使用线程池创建线程
public class Demo1 {
    public static void main(String[] args) {
        //单个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //可伸缩的。遇强则强，遇弱则弱
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        /**
         * 最大线程如何定义
         * 1、CPU密集型  几核，就是几，保持CPU   Runtime.getRuntime().availableProcessors()
         * 2、IO密集型  判断程序中十分耗的IO的线程
         */
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                //超时等待
                2,
                TimeUnit.SECONDS,
                //阻塞队列
                new LinkedBlockingQueue<>(3),
                //默认工厂
                Executors.defaultThreadFactory(),
                /**
                 * 拒绝策略
                 * 队列满还有线程进来
                 * new ThreadPoolExecutor.AbortPolicy()抛出异常
                 * new ThreadPoolExecutor.CallerRunsPolicy()打发回去 由main执行
                 * ThreadPoolExecutor.DiscardPolicy() 不会抛出异常
                 * new ThreadPoolExecutor.DiscardOldestPolicy()  尝试和最早的竞争
                 */
                //
                new ThreadPoolExecutor.CallerRunsPolicy()
                );
        try {
            for (int i = 0; i < 10; i++) {
                //使用线程池创建线程
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                    });
            }
        } finally {
            threadPool.shutdown();
        }

    }
}
