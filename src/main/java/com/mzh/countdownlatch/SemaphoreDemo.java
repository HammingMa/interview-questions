package com.mzh.countdownlatch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //三个车位
        Semaphore semaphore = new Semaphore(3);

        //6辆车
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    //抢到车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");

                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 离开车位");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放车位
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}
