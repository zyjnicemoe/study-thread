package com.zyjblogs.testjuc.forjion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkjoinDemo(0L, 10_0000_0000L);
//        forkJoinPool.execute(task);
        //提交任务
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end - start));
    }

    public static void test3() {
        long start = System.currentTimeMillis();
        //Stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end - start));
    }

    /**
     * 计算公式
     */
    public static void test4() {
        long start = System.currentTimeMillis();
        long sum = (10_0000_0000L * (10_0000_0000L+1L)/2 ) ;
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end - start));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1(); //15654
          test2(); //13187
        test3();//232
        test4();
    }
}
