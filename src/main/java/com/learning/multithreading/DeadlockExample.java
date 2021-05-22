package com.learning.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeadlockExample {

    static final Random r = new Random();
    static final int numberOfAccounts = 5;
    static final int numberOfThreads = 10;

    static volatile List<Account> accounts;

    public static void main(String[] args) {
        accounts = new ArrayList<>();
        for (int id = 0; id < numberOfAccounts; id++) {
            accounts.add(new Account(id));
        }
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Transfer()).start();
        }

    }

    static class Transfer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                int from = r.nextInt(numberOfAccounts);
                int to = r.nextInt(numberOfAccounts);
                int value = r.nextInt(100);
                if (from != to) {
                    Account fromAccount = accounts.get(from);
                    Account toAccount = accounts.get(to);
                    //from - first, to - second
                    // a -> b: a - first, b - second
                    // b -> a: b - first, a - second


                    //low - first, high - second
                    // a > b
                    // a -> b: b - first, a - second
                    // b -> a: b - first, a - second

                    Account monitorFirst = fromAccount.id > toAccount.id ? fromAccount : toAccount;
                    Account monitorSecond = fromAccount.id > toAccount.id ? toAccount : fromAccount;

                    //последовательная блокировка ресурсов
                    synchronized (monitorFirst) {
                        synchronized (monitorSecond) {
                            fromAccount.value -= value;
                            toAccount.value += value;
                        }
                    }
                }
            }
        }
    }

    static class Account {

        private final int id;
        private int value;

        Account(int id) {
            this.id = id;
        }
    }

}
