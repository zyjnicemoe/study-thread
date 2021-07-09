package com.zyjblogs.testjuc.function;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 *
 * @author zhuyijun
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * zhuyijun         2021/7/9 9:20               1.0
 * @program study-thread
 * @description
 * @create 2021/7/9 9:20
 */
public class test {
    public static void main(String[] args) {
        Demo demo = System.out::println;
        demo.prinf("a");
        Demo.printf(1);
    }
}
