package com.mzh.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("================");
        myWeakHashMap();
    }

    public static void myHashMap(){
        Map<Integer,String> map = new HashMap<>();
        Integer key =1;
        map.put(key,"HashMap");

        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());


    }

    public static void myWeakHashMap(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key =new Integer(1);
        map.put(key,"WeakHashMap");

        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.gc();


        System.out.println(map+"\t"+map.size());


    }
}
