package com.mzh.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);


        /*  抛出异常组
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        //System.out.println(queue.add("d"));

        System.out.println(queue.element());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //System.out.println(queue.remove());

        //System.out.println(queue.element());
         */

        /*  返回特殊值组
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        System.out.println(queue.offer("d"));

        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.peek());
         */


        /*  阻塞组
        queue.put("a");
        queue.put("a");
        queue.put("a");
        System.out.println("===========");
        //queue.put("a");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        */

        /*  超时组 */
        System.out.println(queue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(queue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(queue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(queue.offer("d", 2L, TimeUnit.SECONDS));

        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));

    }
}
