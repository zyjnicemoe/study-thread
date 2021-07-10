package com.zyjblogs.testjuc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用才加载
 */
public class LazyMan {
    private static volatile boolean flag = false;
    private LazyMan() {
        synchronized (LazyMan.class) {
            if (flag == false) {
                flag = true;
            }else {
                throw new RuntimeException("不要试图用反射破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName()+ " ok");
    }
    private volatile static  LazyMan lazyMan;

    public static  LazyMan getInstance() {
        //双重检测锁模式的  懒汉式单例 DCL懒汉式
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null ) {
                    //不是原子性操作
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }
    /**
     * 1、分配内存空间
     * 2、执行构造方法，初始化对象
     * 3、把这个对象指向这个空间
     */
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMan.getInstance();
//            }).start();
//        }

        /**
         * 反射破坏单例
         */
//        LazyMan instance = LazyMan.getInstance();

        Field flag = LazyMan.class.getDeclaredField("flag");
        Constructor<LazyMan> declaredConstructor =  LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance2 = declaredConstructor.newInstance();
        flag.set(instance2,false);
        LazyMan instance3 = declaredConstructor.newInstance();
//        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance3);


    }
}
