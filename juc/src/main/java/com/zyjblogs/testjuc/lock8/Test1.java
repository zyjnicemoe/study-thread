package com.zyjblogs.testjuc.lock8;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->phone.sendSms(),"A").start();
        new Thread(()->phone.Hello(),"C").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->phone.call(),"B").start();
    }
}

class Phone{
    //synchronized锁的对象是方法的调用者
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void Hello() {
        System.out.println("hello");
    }
}
