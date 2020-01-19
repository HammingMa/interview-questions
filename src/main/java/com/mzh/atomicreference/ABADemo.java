package com.mzh.atomicreference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);


    public static void main(String[] args) {
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2020) + "\t" + atomicReference.get());

        }, "T2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            int version1 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 版本号为 " + version1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101, version1, version1 + 1);
            int version2 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 版本号为 " + version2);

            atomicStampedReference.compareAndSet(101, 100, version2, version2 + 1);
            int version3 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 版本号为 " + version3);

        }, "T3").start();

        new Thread(() -> {
            int version1 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 版本号为 " + version1);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = atomicStampedReference.compareAndSet(100, 2020, version1, version1 + 1);
            int version2 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"修改的结果"+result+" 当前的值为"+atomicStampedReference.getReference());
            System.out.println(Thread.currentThread().getName() + " 版本号为 " + version2);

        }, "T4").start();



    }
}
