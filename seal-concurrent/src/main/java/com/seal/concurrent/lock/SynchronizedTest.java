package com.seal.concurrent.lock;

/**
 * Synchronized关键字不起作用
 *
 * @author fengzhiqiang
 * @date-time 2020/6/17 10:38
 **/
public class SynchronizedTest {

    public static void main(String[] args) {
        final SynchronizedTest sychor = new SynchronizedTest();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                // sychor.insert1(Thread.currentThread());
                // sychor.insert2(Thread.currentThread());
                sychor.insert3(Thread.currentThread());
            }

            ;
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                // sychor.insert1(Thread.currentThread());
                // sychor.insert2(Thread.currentThread());
                sychor.insert3(Thread.currentThread());
            }

            ;
        };
        t1.start();
        t2.start();
    }

    /**
     * 未加synchronized输出的结果是没有顺序的
     * @param thread
     */
    public void insert1(Thread thread) {
        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName() + "输出:  " + i);
        }
    }

    /**
     * 线程同步方法
     * 加了synchronized输出的结果是有顺序的
     *
     * @param thread
     */
    public synchronized void insert2(Thread thread) {
        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName() + "输出:  " + i);
        }
    }

    /**
     * 线程同步块
     *
     * @param thread
     */
    public void insert3(Thread thread) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(thread.getName() + "输出:  " + i);
            }
        }
    }
}
