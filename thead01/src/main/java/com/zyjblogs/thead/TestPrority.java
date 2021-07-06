package com.zyjblogs.thead;

/**
 * 线程优先级 先设置优先级 在运行
 */
public class TestPrority {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPrority myPrority = new MyPrority();

        Thread t1 = new Thread(myPrority);
        Thread t2 = new Thread(myPrority);
        Thread t3 = new Thread(myPrority);
        Thread t4 = new Thread(myPrority);
        Thread t5 = new Thread(myPrority);
        Thread t6 = new Thread(myPrority);

        //先设置优先级
        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(4);
        t3.start();
        //MAX_PRIORITY=10
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
        t5.setPriority(8);
        t5.start();
        t6.setPriority(7);
        t6.start();
    }
}

class MyPrority implements Runnable {

    @Override
    public void run() {
        //打印优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}