package com.mytasks;
/*
LinkedHashMap для строк
 */
import java.util.LinkedHashMap;

public class MyLinkedHashMap<T> {
    private Element header;
    private Element[] table;

    MyLinkedHashMap() {     //Емкость по умолчанию
        this.header = new Element(-1, null, null, null, null, null);
        this.header.after = this.header;
        this.header.before = this.header;
        table = new Element[16];
    }

    MyLinkedHashMap(int capacity){      //Пользовательская емкость
        this.header = new Element(-1, null, null, null, null, null);
        this.header.after = this.header;
        this.header.before = this.header;
        table = new Element[capacity];
    }

    private class Element<T> {
        int hash;
        Key key;
        String value;
        Element next;
        Element after;
        Element before;

        Element(int hash, Key key, String value, Element next, Element after, Element before) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    class Key {
        private T key;
        private int hashCode;
        Key(T key) {
            this.key = key;
        }

        T getKey() {
            return key;
        }

        int createHash(T key) {     //Взял подсчет хэша по умолчанию
            return key.hashCode();
        }
    }

    void put(T key, T value) {
        Key objKey = new Key(key);
        int hashCode = objKey.createHash(key);
        //Element element = new Element(hashCode, key, value, );

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
        MyLinkedHashMap map = new MyLinkedHashMap(11);
        LinkedHashMap map1 = new LinkedHashMap();
        //map.put("idx", "two");
       // map1.put()
    }
}