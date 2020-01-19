package com.mzh.productconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int number = 1;

    Lock lock = new ReentrantLock();


    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {

        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 0; i < number * 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {

        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 0; i < number * 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 0; i < number * 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print() {


        lock.lock();

        try {

            int num = Integer.parseInt(Thread.currentThread().getName());
            Condition curCondition = null;
            Condition nextCondition = null;
            switch (num) {
                case 1:
                    curCondition = c1;
                    nextCondition = c2;
                    break;
                case 2:
                    curCondition = c2;
                    nextCondition = c3;
                    break;
                case 3:
                    curCondition = c3;
                    nextCondition = c1;
                    break;
            }


            while (number != num) {

                curCondition.await();
            }

            for (int i = 0; i < number * 5; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            number = (number % 3) + 1;
            nextCondition.signal();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

public class SyncAndReentrantLock {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                shareResource.print5();
//            }
//        }, "A").start();
//
//
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                shareResource.print10();
//            }
//        }, "B").start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                shareResource.print15();
//            }
//        }, "C").start();


        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    shareResource.print();
                }

            }, String.valueOf(i)).start();
        }

    }
}
