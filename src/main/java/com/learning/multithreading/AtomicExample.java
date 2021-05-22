package com.learning.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    public static void main(String[] args) {
        //CAS compare and swap
        //if (value == x) {
        // value = y;
        //}

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(10, 15);
        int i = atomicInteger.getAndIncrement(); //positive block

    }

}
