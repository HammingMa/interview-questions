package com.mzh.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(5);

        System.out.println(a.compareAndSet(5, 2019)+"\t current data "+ a);
        System.out.println(a.compareAndSet(5, 2020)+"\t current data "+ a);
    }
}
