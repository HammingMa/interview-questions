package com.bytedance;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerAndConsumer {


    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        MyResource myResource = new MyResource(queue);

        new Thread(() -> {
            try {
                System.out.println("生产者启动了。。。。。。。。");
                myResource.myProducer();
                System.out.println("生产者停止了。。。。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "生产者1").start();

        new Thread(() -> {
            try {
                System.out.println("消费者启动了。。。。。。。。");
                myResource.myConsumer();
                System.out.println("消费者停止了。。。。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "消费者1").start();


        TimeUnit.SECONDS.sleep(5L);

        myResource.stop();
    }
}

class MyResource {
    private AtomicInteger data;
    private BlockingQueue<String> queue;
    private boolean falg;

    public MyResource(BlockingQueue<String> queue) {

        this.queue = queue;
        data = new AtomicInteger();

        falg = true;
    }

    public void myProducer() throws Exception {
        int d;
        while (falg) {
            d = data.getAndIncrement();
            boolean b = queue.offer(Integer.toString(d), 2L, TimeUnit.SECONDS);
            if (b) {
                System.out.println(Thread.currentThread().getName() + "生产数据" + d + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "生产数据" + d + "失败");
            }
            TimeUnit.SECONDS.sleep(1L);
        }

        System.out.println("生产者停止了，flag=" + falg);
    }

    public void myConsumer() throws Exception {
        String d;
        while (falg) {
            d = queue.poll(2L, TimeUnit.SECONDS);
            if (d == null || d.isEmpty()) {
                falg = false;
                System.out.println(Thread.currentThread().getName() + "超过2秒没有消费到数据，任务停止 flag=" + falg);
                return;
            } else {
                System.out.println(Thread.currentThread().getName() + "消费数据" + d);
            }

            //TimeUnit.SECONDS.sleep(1L);
        }
    }


    public void stop() {
        this.falg = false;
    }


}
