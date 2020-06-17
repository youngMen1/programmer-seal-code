package com.seal.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Atomic原子操作类介绍
 *
 * @author fengzhiqiang
 * @date-time 2020/6/16 16:51
 **/
public class AtomicTest {

    /**
     * 基本数据类型
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * 数组数据类型
     */
    private static int[] value = new int[]{1, 2, 3};
    private static AtomicIntegerArray integerArray = new AtomicIntegerArray(value);

    /**
     * 引用类型
     */
    private static AtomicReference<User> reference = new AtomicReference<>();

    /**
     * 字段类型
     */
    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(User2.class,"age");


    public static void main(String[] args) {
        // 对基本数据
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());

        // 对数组中索引为1的位置的元素加5
        int result = integerArray.getAndAdd(1, 5);
        System.out.println(integerArray.get(1));
        System.out.println(result);

        // 引用类型
        User user1 = new User("a", 1);
        reference.set(user1);
        User user2 = new User("b",2);
        User user3 = reference.getAndSet(user2);
        System.out.println(user3);
        System.out.println(reference.get());


        // 字段类型
        User2 user5 = new User2("a", 1);
        int oldValue = updater.getAndAdd(user5, 5);
        System.out.println(oldValue);
        System.out.println(updater.get(user5));
    }

    static class User {
        private String userName;
        private int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class User2 {
        private String userName;
        public volatile int age;

        public User2(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
