package com.zyjblogs.testjuc.bq;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        test();
//        test2();
//        test3();
//        test4();
        test5();
    }

    public static void test() {
        //队列大小
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println("------------------");
        //java.lang.IllegalStateException: Queue full  队列满了
        // blockingQueue.add("d");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException 没有元素 去移除报错
        //System.out.println(blockingQueue.remove());

    }


    //异常抛出
    public static void test2() {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //flase满了不抛出异常
        System.out.println(blockingQueue.offer("d"));
        System.out.println("-----------------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //没元素去弹出  则返回为空null
        System.out.println(blockingQueue.poll());
    }

    //异常不抛出
    public static void test3() {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //检测队首元素
        System.out.println(blockingQueue.peek());
        //flase满了不抛出异常
        System.out.println(blockingQueue.offer("d"));
        System.out.println("-----------------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //没元素去弹出  则返回为空null
        System.out.println(blockingQueue.poll());
    }

    /**
     * 阻塞队列
     *
     * @throws InterruptedException
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //队列满了 再去存会一直阻塞
//        blockingQueue.put("d");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //没有这个元素去弹出也会一直等待 一直阻塞
//        System.out.println(blockingQueue.take());

    }

    /**
     * 超时退出
     *
     * @throws InterruptedException
     */
    public static void test5() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //队列满了 再去存会等待2秒 超时退出
        blockingQueue.offer("d",2,TimeUnit.SECONDS);
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));

    }
}
