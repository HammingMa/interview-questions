package com.mzh.unsafelist;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        //ConcurrentModificationException
        //Map<String,String> map = new HashMap<>();
        //Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();


        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0, 8), Thread.currentThread().getName());
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void NoSafeArrayList() {
        //1 1.2版本
        // List<String> list = new ArrayList<>(); //异常 java.util.concurrentModificationException
        //2 1.0版本
        //List<String> list = new Vector<>();
        //3
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //4
        List<String> list = new CopyOnWriteArrayList<>();


        //并发修改导致的异常
        //java.util.ConcurrentModificationException
        //java.util,concurrentModificationException

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
