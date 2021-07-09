package com.zyjblogs.testjuc.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Function 函数式接口 ，有一个输入参数，有一个输出
 * 只要是函数式接口  可以用lamdba表达式简化
 */
public class FunctionDemo {
    public static void main(String[] args) {
        //函数式接口
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };


          Function function = (str) ->{
            return str;
          };
//        Function function = str -> str;

        System.out.println(function.apply("abc"));
    }
}
