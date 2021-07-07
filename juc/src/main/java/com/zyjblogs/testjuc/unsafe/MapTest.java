package com.zyjblogs.testjuc.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            service.execute(map.put());
        }
        service.shutdown();
    }
}
