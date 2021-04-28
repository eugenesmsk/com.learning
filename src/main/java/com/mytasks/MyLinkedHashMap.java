package com.mytasks;
/*
LinkedHashMap для строк
 */
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MyLinkedHashMap<T> {
    private Element header;
    private ArrayList<Element>[] table;
    private int size = 0;

    MyLinkedHashMap() {     //Емкость по умолчанию
        this.header = new Element(-1, null, null);
        this.header.after = this.header;
        this.header.before = this.header;
        table = new ArrayList[16];
    }

    MyLinkedHashMap(int capacity){      //Пользовательская емкость
        this.header = new Element(-1, null, null);
        this.header.after = this.header;
        this.header.before = this.header;
        table = new ArrayList[capacity];
    }

    private class Element<T> {
        int hash;
        T key;
        T value;
        Element next;
        Element after;
        Element before;

        Element(int hash, T key, T value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    void put(T key, T value) {
        int hashCode = hash(key.hashCode());
        Element element = new Element(hashCode, key, value);
        int bucketNum = calculateBucket(hashCode, table.length);
        if(isEmptyBucket(bucketNum)) {
            table[bucketNum] = new ArrayList<>();
            table[bucketNum].add(element);
            ++size;
            //Проверяем на первый элемент, чтобы добавить ссылки в header
            if(size == 1) {
                header.after = element;
                header.before = element;
                element.before = header;
                element.after = header;

            }
            else {
                header.before.after = element;
                element.before = header.before;
                element.after = header;
                header.before = element;
            }
        }
        else {
            table[bucketNum].add(element);
            ++size;
            setNext(bucketNum, element);
            //Дописать изменение поля after у предыдущего объекта после добавления нового
            element.before = header.before;
            element.after = header;
            header.before = element;
            table[bucketNum].get(table[bucketNum].size() - 2).after = element;

        }
    }

    int size() {
        return size;
    }

    private void setNext(int bucketNum, Element element) {      //Устанавливаем поле прыдыдущего элемента next на вновь добавленный
        table[bucketNum].get(table[bucketNum].size() - 2).next = element;
    }



   private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

   private int calculateBucket(int hashCode, int capacity) {
        return (hashCode & (capacity - 1));
    }

    private boolean isEmptyBucket(int bucket) {
        return table[bucket] == null;
    }

}

class R {
    public static void main(String[] args) {
        MyLinkedHashMap map = new MyLinkedHashMap();
        map.put(1, "obj1");
        map.put(15, "obj15");
        map.put(38, "obj38");
        System.out.println(map.size());
    }
}