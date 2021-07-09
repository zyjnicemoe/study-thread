package com.zyjblogs.testjuc.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        MyCache myCache = new MyCache();
        MyLockCache myCache = new MyLockCache();
        for (int i = 1; i <= 20; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class   MyCache{
    private volatile Map<String,Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入OK"+key);
    }
    public void get(String key) {
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取OK"+key);
    }
}
class   MyLockCache{
    private volatile Map<String,Object> map = new HashMap<>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入OK"+key);
        }finally {
            lock.writeLock().unlock();
        }

    }
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK"+key);
        }finally {
            lock.readLock().unlock();
        }
    }
}
