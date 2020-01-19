package com.mzh.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

public class PhanTomReferenceDemo {

    public static void main(String[] args) throws Exception {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> p1 = new PhantomReference<>(o1, queue);

        System.out.println(o1);
        System.out.println(p1.get());
        System.out.println(queue.poll());

        System.out.println("============");

        o1 = null;

        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println(o1);
        System.out.println(p1.get());
        System.out.println(queue.poll());

    }
}
