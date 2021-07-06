package com.zyjblogs.thead;

import java.util.concurrent.*;

public class TestCallable01 implements Callable<Boolean> {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        TestCallable01 t1 = new TestCallable01();
        TestCallable01 t2 = new TestCallable01();
        TestCallable01 t3 = new TestCallable01();
        Future<Boolean> submit1 = executorService.submit(t1);
        Future<Boolean> submit2 = executorService.submit(t2);
        Future<Boolean> submit3 = executorService.submit(t3);
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        try {
            b1 = submit1.get();
            b2 = submit2.get();
            b3 = submit3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (b1 && b2 && b3) {
            System.out.println("完成");
        }
        executorService.shutdown();
    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看---" + i);
        }
        return true;
    }
}
