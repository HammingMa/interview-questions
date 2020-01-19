package com.mzh.lock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        System.out.println(Thread.currentThread().getName() + " come in !!!");

        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {

        }

    }


    public void myUnLock() {
        System.out.println(Thread.currentThread().getName() + " go out !!!");
        atomicReference.compareAndSet(Thread.currentThread(), null);
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLockDemo.myUnLock();

        }, "T1").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            spinLockDemo.myLock();


            spinLockDemo.myUnLock();

        }, "T2").start();

    }
}
