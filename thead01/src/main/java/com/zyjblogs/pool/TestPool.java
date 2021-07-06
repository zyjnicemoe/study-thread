package com.zyjblogs.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        //newFixedThreadPool 参数为线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        //执行
        service.execute(new MyThead());
        service.execute(new MyThead());
        service.execute(new MyThead());
        service.execute(new MyThead());

        //2.关闭连接
        service.shutdown();
    }
}

class MyThead implements  Runnable{

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
    }
}