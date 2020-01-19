package com.mzh.reference;

import sun.jvm.hotspot.utilities.BitMap;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> w1 = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(w1.get());

        o1=null;
        System.gc();

        System.out.println(o1);
        System.out.println(w1.get());

        Map<String, SoftReference<BitMap>> imageCache = new HashMap<>();


    }
}
