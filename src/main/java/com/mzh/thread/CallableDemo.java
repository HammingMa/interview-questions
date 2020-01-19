package com.mzh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class myThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t come in callable!");
        TimeUnit.SECONDS.sleep(2L);
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws Exception {

        System.out.println(Runtime.getRuntime().availableProcessors());

        FutureTask<Integer> futureTask = new FutureTask<>(new myThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new myThread());

        new Thread(futureTask, "AA").start();
        new Thread(futureTask2, "BB").start();


        Integer num = futureTask.get();


        System.out.println(Thread.currentThread().getName()+"************");
        int i = 100;

        // Integer num = futureTask.get();  13801630782

        System.out.println(i + num);

    }
}
