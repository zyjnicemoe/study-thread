package com.zyjblogs.testjuc.single;

/**
 * 静态内部类
 */
public class Holder {
    public Holder() {

    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }
    public static  class  InnerClass{
        private static  final  Holder HOLDER = new Holder();

    }

}
