package com.mzh.productconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> queue = null;

    public MyResource(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void myProduct() throws Exception {

        while (FLAG) {
            String data = String.valueOf(atomicInteger.getAndIncrement());
            boolean b = queue.offer(data, 2L, TimeUnit.SECONDS);
            if (b) {
                System.out.println(Thread.currentThread().getName() + "\t 生产了数据：" + data);
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 生产数据：" + data+" 失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("大老板叫停了 FLAG = " + FLAG);
    }

    public void myConsumer() throws Exception {
        while (FLAG) {
            String data = queue.poll(2L, TimeUnit.SECONDS);
            if(data==null || "".equals(data)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"超过两秒没消费到数据消费者退出 FLAG = " + FLAG);
                return;
            }

            System.out.println(Thread.currentThread().getName() + "\t 消费了数据：" + data);

        }
    }

    public void stop(){
        FLAG = false;
    }
}


public class ProductConsumerBlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(3));

        new Thread(()->{
            System.out.println("生产线程启动了");
            try {
                myResource.myProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println("消费线程启动了");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myResource.stop();
    }
}
