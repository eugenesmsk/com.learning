package com.learning.multithreading;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BlockingQueue {

    //spurious wakeups
    private final Queue<Integer> linkedList = new LinkedList<>();
    private final int maxElements;

    public BlockingQueue(int maxElements) {
        this.maxElements = maxElements;
    }

    public void push(int value) throws InterruptedException {
        System.out.println("push " + value);
        synchronized (this) {
            while (linkedList.size() >= maxElements) {
                this.wait();
            }
            linkedList.add(value);
            this.notifyAll();
        }
    }

    public int poll() throws InterruptedException {
        System.out.println("poll");
        synchronized (this) {
            while (linkedList.isEmpty()) {
                this.wait();
            }
            int value = linkedList.poll();
            this.notifyAll();
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(3);
        blockingQueue.push(1);
        blockingQueue.push(2);
        blockingQueue.push(3);
        blockingQueue.push(4);
    }

}
