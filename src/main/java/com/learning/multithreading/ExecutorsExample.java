package com.learning.multithreading;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "!!!");
            }
        });

        Future<Integer> callableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Calculations ....");
                return 42;
            }
        });
        while (!callableFuture.isDone()) {

        }
        Integer result = callableFuture.get();
        System.out.println(result);
        executorService.shutdown();

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("calculations...");
                return 30;
            }
        }, executorService);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 15;
            }
        });

    }

}
