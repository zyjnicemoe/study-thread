package com.zyjblogs.testjuc.function;

import java.util.function.Predicate;

/**
 * 函数式接口
 */
public class PredicateDemo {
    public static void main(String[] args) {
        /*Predicate predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*/
//        Predicate<String> predicate = (str)->{
//            return str.isEmpty();
//        };
        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test("1"));
    }
}
