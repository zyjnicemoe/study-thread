package com.zyjblogs.testjuc.lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
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

//为一个一个Class对象
class Phone2{
    //synchronized锁的对象是方法的调用者
    //static静态方法
    //类一加载就有了！ Class模板
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }

    public void Hello() {
        System.out.println("hello");
    }
}
