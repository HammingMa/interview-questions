package com.mzh.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    //int number = 0;
    volatile int number = 0;

    public void addTo60() {
        number = 60;
    }

    public void addOne() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

public class Volatile {
    public static void main(String[] args) {

        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addOne();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() +" int type , read finally number value : "+myData.number);
        System.out.println(Thread.currentThread().getName() +" AtomicInteger read finally number value : "+myData.atomicInteger);
    }

    //volatile 保证原子性
    private static void SeeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            myData.addTo60();

            System.out.println(Thread.currentThread().getName() + " update number value " + myData.number);

        }, "AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + " mission is over , get number value " + myData.number);
    }
}
