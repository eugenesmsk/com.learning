package com.mytasks.multithreading;

public class ThreadExample {
    static int i = 0;
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    i++;
                }
            }
        });
        thread.start();
    }

}



