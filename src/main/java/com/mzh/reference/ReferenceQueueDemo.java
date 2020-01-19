package com.mzh.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> w1 = new WeakReference<>(o1, queue);

        System.out.println(o1);
        System.out.println(w1.get());
        System.out.println(queue.poll());

        System.out.println("=============");

        o1 = null;
        System.gc();

        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println(o1);
        System.out.println(w1.get());
        System.out.println(queue.poll());


    }
}
