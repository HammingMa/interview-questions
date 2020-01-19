package com.mzh.thread;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {
    private String aLock;
    private String bLock;

    public HoldLockThread(String aLock, String bLock) {
        this.aLock = aLock;
        this.bLock = bLock;
    }

    @Override
    public void run() {
        synchronized (aLock) {
            System.out.println(Thread.currentThread().getName() + "\t持有" + aLock + "尝试获取" + bLock);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (bLock) {
                System.out.println(Thread.currentThread().getName() + "\t持有" + bLock + "尝试获取" + aLock);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String aLock = "alock";
        String bLock = "block";
        HoldLockThread thread1 = new HoldLockThread(aLock, bLock);
        HoldLockThread thread2 = new HoldLockThread(bLock, aLock);

        new Thread(thread1,"AAAA").start();
        new Thread(thread2,"BBBB").start();

//        int i=0;
//        while (true) {
//            i = 1 + 1;
//        }

    }
}
