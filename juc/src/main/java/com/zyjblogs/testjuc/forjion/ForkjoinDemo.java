package com.zyjblogs.testjuc.forjion;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算
 * 1、ForkJionPool通过他来执行
 * 2、计算任务 execute(ForkJoinTask<?> task)
 * ForkJoinTask
 */
public class ForkjoinDemo extends RecursiveTask<Long> {
    private long start;
    private long end;
    //临界值
    private long temp = 10000L;

    public ForkjoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) > temp) {
            //分支合并计算
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        long middle = (start + end) / 2;
        ForkjoinDemo task1 = new ForkjoinDemo(start, middle);
        //拆分任务，把任务压入线程队列
        task1.fork();
        ForkjoinDemo task2 = new ForkjoinDemo(middle, end);
        task2.fork();
        return task1.join() + task1.join();
    }
}
