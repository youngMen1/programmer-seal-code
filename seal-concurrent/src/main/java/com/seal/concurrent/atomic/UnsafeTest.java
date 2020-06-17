package com.seal.concurrent.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * CAS在Java中的使用
 *
 * @author fengzhiqiang
 * @date-time 2020/6/16 16:20
 **/
public class UnsafeTest {

    private static Unsafe unsafe;

    static {
        try {
            // 通过反射获取rt.jar下的Unsafe类
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println("Get Unsafe instance occur error" + e);
        }
    }

    public static void main(String[] args) throws Exception {
        Class clazz = Target.class;
        Field[] fields = clazz.getDeclaredFields();
        Target target = new Target();
        Field intFiled = clazz.getDeclaredField("intParam");
        Field longFiled = clazz.getDeclaredField("longParam");
        Field strFiled = clazz.getDeclaredField("strParam");
        Field strFiled2 = clazz.getDeclaredField("strParam2");

        // intParam
        System.out.print(unsafe.compareAndSwapInt(target, 12, 3, 10) + ":");
        System.out.println((Integer) intFiled.get(target));
        // longParam
        System.out.print(unsafe.compareAndSwapLong(target, 16, 1L, 2L) + ":");
        System.out.println((Long) longFiled.get(target));
        // strParam
        System.out.print(unsafe.compareAndSwapObject(target, 24, null, "5")
                + ":");
        System.out.println((String) strFiled.get(target));
        // strParam2
        System.out.print(unsafe.compareAndSwapObject(target, 28, null, "6")
                + ":");
        System.out.println((String) strFiled2.get(target));

    }

    static class Target {
        int intParam = 3;
        long longParam = 1L;
        String strParam;
        String strParam2;
    }
}
