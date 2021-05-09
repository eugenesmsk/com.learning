package com.learning.multithreading;

public class ThreadExample {

    /*

    w1              r ? 1 or 2
        w2



    bool b = false;
    int x = 0;

    thread1:        thread2:
    x = 1           if (b) {
    b = true              print(x);  //? 0
                    }


    int a = 0;
    a = 1;
    int b = a + 2; //program order

    synchronized with: pairs of synchronized actions
    w volatile -> r volatile
    finish synchronized -> start synchronized
    join -> r

    int x;
    volatile int y;

    t1:                 t2;
    x = 1               print(y)
    y = x + 2;          print(x)
     */

    static int x = 0;
    private static final Object mon = new Object();

    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    synchronized (mon) {
                        x++; //r v; newv = v + 1; w newv
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    synchronized (mon) {
                        x++;
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("x=" + x);
    }

}
