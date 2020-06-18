package com.seal.concurrent.lock;

/**
 * @author fengzhiqiang
 * @date-time 2020/6/17 14:02
 **/
public class SynchronizedTest2 {

    /**
     * 此时线程同步块根本不起作用，因为他们调用的是不同对象的insert方法，获得锁是不一样的
     * 我们知道每一个对象都有一把锁，当我们使用线程同步方法或者线程同步块的时候实际上获得是对象的唯一的一把锁，
     * 当一个线程获得了这唯一的锁，那么其他的线程只能拒之门外了，
     * 注意这里我们说是一个对象，也就是说是同一个对象，
     * 如果是不同的对象，那么就不起作用了，
     * 因为不同对象有不同的对象锁
     *
     * @param args
     */
    public static void main(String[] args) {
        //第一个线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                SynchronizedTest2 sychor = new SynchronizedTest2();
                // 在run() 方法中创建一个对象
                sychor.insert(Thread.currentThread());
            }

            ;
        };
        // 第二个线程
        Thread t2 = new Thread() {
            @Override
            public void run() {
                SynchronizedTest2 sychor = new SynchronizedTest2();
                // 创建另外的一个对象
                sychor.insert(Thread.currentThread());
            }

            ;
        };
        t1.start();
        t2.start();
    }

    public void insert(Thread thread) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(thread.getName() + "输出:  " + i);
            }
        }
    }




}
