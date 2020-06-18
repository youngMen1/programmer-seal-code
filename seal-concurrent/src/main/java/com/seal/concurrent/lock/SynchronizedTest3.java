package com.seal.concurrent.lock;

/**
 * 一个类也有唯一的一把锁，我们前面说的是使用对象调用成员方法，
 * 现在如果我们要调用类中的静态方法，那么我们可以使用线程同步方法或者同步块获得类中的唯一一把锁
 * @author fengzhiqiang
 * @date-time 2020/6/17 14:14
 **/
public class SynchronizedTest3 {

    // 静态方法
    public static synchronized void insert(Thread thread) {
        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName() + "输出     " + i);
        }
    }

    public static void main(String[] args) {
        //第一个线
        Thread t1 = new Thread() {
            @Override
            public void run() {
                SynchronizedTest3.insert(Thread.currentThread());
                //直接使用类调用静态方法
            }

            ;
        };
        //第二个线程
        Thread t2 = new Thread() {
            @Override
            public void run() {
                SynchronizedTest3.insert(Thread.currentThread());
                //直接使用类调用静态方法
            }

            ;
        };
        t1.start();
        t2.start();
    }
}
