package com.zyjblogs.testjuc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举 枚举本身也是class类
 */
public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance() {
        return INSTANCE;
    }


}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingle enumSingle =  EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle1 = declaredConstructor.newInstance();
        System.out.println(enumSingle);
        System.out.println(enumSingle1);
    }
}