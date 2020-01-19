package com.mzh.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    public synchronized void sendMSM() {
        System.out.println(Thread.currentThread().getName() + "-------- invoked sendMSM");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "-------- invoked sendEmail");
    }

    public void get() {
        lock.lock();
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-------- invoked get");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            //lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-------- invoked set");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        this.get();
    }
}

public class ReLock {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendMSM();
        }, "T1").start();


        new Thread(() -> {
            phone.sendMSM();
        }, "T2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        Thread t3 = new Thread(phone, "T3");
        Thread t4 = new Thread(phone, "T4");

        t3.start();
        t4.start();
    }
}
