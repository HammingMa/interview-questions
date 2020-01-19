package com.mzh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        //固定数的线层池 1池5线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池1线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一池N线程 根据任务数量自动分派线程数
        ExecutorService threadPool = Executors.newCachedThreadPool();



        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务！");
                });
                //TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            threadPool.shutdown();
        }
    }
}
