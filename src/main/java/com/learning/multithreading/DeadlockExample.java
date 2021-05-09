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
        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new Account());
        }
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Transfer()).start();
        }

    }

    static class Transfer implements Runnable {

        @Override
        public void run() {
            int from = r.nextInt(numberOfAccounts);
            int to = r.nextInt(numberOfAccounts);
            if (from != to) {

            }
        }
    }

    static class Account {

        private int value;

    }

}
