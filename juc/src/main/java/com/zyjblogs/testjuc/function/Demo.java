package com.zyjblogs.testjuc.function;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 *
 * @author zhuyijun
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * zhuyijun         2021/7/9 9:18               1.0
 * @program study-thread
 * @description
 * @create 2021/7/9 9:18
 */
@FunctionalInterface
public interface Demo {
     void prinf(String str);

     default void printf(String str) {
         System.out.println("输出"+str);
     }

     static  void printf(Integer a) {
         System.out.println(a);
     }
}
