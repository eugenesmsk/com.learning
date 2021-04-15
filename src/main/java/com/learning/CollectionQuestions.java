package com.learning;

import java.util.*;

public class CollectionQuestions {

    /**
     *
     * Предлагаю ознакомиться с этими статьями. Первая - обзор коллекций, остальные - детали реализации нескольких популярных коллекций.
     * На собеседованиях нужно быть готовым ответить на вопросы:
     * - расскажите иерархию коллекций
     * - в чем различие List и Set
     * - в чем различие ArrayList и LinkedList
     * - сколько максимум объектов может содержать ArrayList
     * - какова сложность каждой из операций
     * - каков контракт между equals и hashCode
     * - гарантируется ли уникальность hashCode
     * - каковы требования к hashCode, что будет если его нарушить
     * - как можно потерять элемент в HashMap
     * - MyClass является наследником Object, является ли List<MyClass> наследником List<Object>
     * - можно ли в итераторе по List удалять элементы из этого же листа
     *
     */

    public static void main(String[] args) {
        Collection collection;
        Iterable iterable;
        Iterable<String> list = List.of("a", "b", "c");
        Iterator<String> iterator = list.iterator();
        Iterable<Integer> myIterable = new OneTwoThreeIterable();
        for (int x: myIterable) {
            System.out.println(x);
        }

        List<String> arrayList = new ArrayList<>(20);
        // f(n) = O(g(n)) ==def== f(n)/g(n) -> C != 0, n -> +inf
        arrayList.add("a"); //O(1) arr[13] = "a"
        arrayList.contains("x"); //O(n)
        arrayList.remove("a"); //O(n)
        arrayList.get(3);

        for (String x : arrayList) {
            arrayList.remove(x); //ConcurrentModificationException
        }
        //O(1) < O(log n) < O(n) < O(n * log n) < O( n^2 )

        List<String> linkedList = new LinkedList<>();
        //a <-> b <-> x <-> c
        //get - O(n)

        Set<String> set = new HashSet<>();

        Queue<String> queue; //fifo
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1); //O(1),  worst case: O(n)
        map.put("b", 2);
        System.out.println(map.get("a")); //O(1)

        //buckets [][][][][]
        //        "a" "b"
        //        "123"
        "a".hashCode();
        //bucket number, hashCode -> bucket n


        Stack<String> stack; //fiаo
    }

    public static class InfitineRandomIterable implements Iterable<Integer> {

        private final Random random = new Random();

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    return random.nextInt();
                }
            };
        }
    }

    public static class OneTwoThreeIterable implements Iterable<Integer> {

        private final int[] array = new int[] { 1, 2, 3, 4, 6 };

        @Override
        public Iterator<Integer> iterator() {

            return new Iterator<Integer>() {

                private int position = 0;

                @Override
                public boolean hasNext() {
                    return position < array.length;
                }

                @Override
                public Integer next() {
                    int value = array[position];
                    position++;
                    return value;
                }
            };
        }
    }

}
