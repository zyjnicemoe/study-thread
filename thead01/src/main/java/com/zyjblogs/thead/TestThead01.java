package com.zyjblogs.thead;

/**
 *  线程
 * @author zhuyi
 */
public class TestThead01 extends Thread {

    @Override
    public void run() {
        for (int i=0;i <20;i++) {
            System.out.println("我在看---"+i);
        }
    }

    public static void main(String[] args) {
        TestThead01 testThead01 = new TestThead01();
        testThead01.start();
        for (int i=0;i <200;i++) {
            System.out.println("我在学习多线程---"+i);
        }
    }
}
