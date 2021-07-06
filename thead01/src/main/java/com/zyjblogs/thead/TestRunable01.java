package com.zyjblogs.thead;

import java.util.concurrent.ThreadPoolExecutor;

public class TestRunable01 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i <200;i++) {
            System.out.println("我在看---"+i);
        }
    }

    public static void main(String[] args) {
        TestRunable01 t1 = new TestRunable01();
        new Thread(t1).start();
        for (int i=0;i <200;i++) {
            System.out.println("我在学习多线程---"+i);
        }
    }
}
