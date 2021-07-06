package com.zyjblogs.thead;

public class TestRunable02 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
       while (true) {
           if (ticketNums <= 0) {
               break;
           }
           try {
               Thread.sleep(200);
               //TODO 并发之后需要解决
                   ticketNums--;
                   System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums +"票");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
    }

    public static void main(String[] args) {
        TestRunable02 ticket01 = new  TestRunable02();
        new Thread(ticket01,"张三").start();
        new Thread(ticket01,"李四").start();
        new Thread(ticket01,"王五").start();
    }
}
