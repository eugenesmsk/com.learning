package com.mytasks.leetcode;

//Accepted

class PrintInOrder {
    int flag;
    public PrintInOrder() {
        flag = 0;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while(flag == 0) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;
            notifyAll();
            break;
        }
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(flag != 1) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(flag != 2) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

