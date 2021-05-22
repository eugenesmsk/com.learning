package com.learning.multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeCollections {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        //t1: list.forEach .. //1
        list.add(2);
        //t2: list.forEach .. //1, 2

        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Map<String, Integer> hashMap = new LinkedHashMap<>();
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(hashMap);
    }

}
