package com.mzh.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {


        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入\t" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(key, value);

            System.out.println(Thread.currentThread().getName() + "\t写入完成\t");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }

    public void get(String key) {

        lock.readLock().lock();

        try {

            System.out.println(Thread.currentThread().getName() + "\t正在去读\t");

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object result = map.get(key);

            System.out.println(Thread.currentThread().getName() + "\t读取完成\t" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }



    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tmpInt = i;
            new Thread(() -> {
                myCache.put(String.valueOf(tmpInt), String.valueOf(tmpInt));
            }, "T" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tmpInt = i;
            new Thread(() -> {
                myCache.get(String.valueOf(tmpInt));
            }, "T" + i).start();
        }
    }
}
