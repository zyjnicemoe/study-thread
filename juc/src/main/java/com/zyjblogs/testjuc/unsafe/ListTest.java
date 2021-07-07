package com.zyjblogs.testjuc.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //不安全
        // List<String> list = new ArrayList<>();
        //安全
        //  List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        //CopyOnWrite 写入时防复制  COW 计算机程序设计领域的一种优化策略
        //多个线程调用得到时候，list，读取的时候  固定的  写入(覆盖)
        //读写分离
        /**
         * CopyOnWriteArrayList  对比 Vector
         *
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            service.execute(new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)));
        }
        service.shutdown();
    }
}
