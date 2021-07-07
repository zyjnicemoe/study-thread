package com.zyjblogs.testjuc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
//    condition.await();  //等待
//    condition.signalAll(); //唤醒全部
    private int num = 0;

    public void lockIncrement() {
        lock.lock();
        try{
            while (num != 0) {
                //等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "数字为" + num);
            //通知其他线程，我完成了减一
            condition.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void lockDecrement() {
        lock.lock();
        try{
            while (num == 0) {
                //等待
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "数字为" + num);
            //通知其他线程，我完成了减一
            condition.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void increment() {

        while (num != 0) {
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "数字为" + num);
        //通知其他线程，我完成了减一
        this.notifyAll();
    }

    public synchronized void decrement() {
        while (num == 0) {
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "数字为" + num);
        //通知其他线程，我完成了减一
        this.notifyAll();
    }
}
