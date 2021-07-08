package com.zyjblogs.testjuc.function;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "ok";
//            }
//        };
        Supplier<String> supplier = () -> "ok";
        System.out.println(supplier.get());
    }
}
