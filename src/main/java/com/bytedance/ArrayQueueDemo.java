package com.bytedance;

public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        queue.show();

        System.out.println(queue.peek());

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.show();
        System.out.println(queue.peek());
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.println(queue.peek());
        queue.show();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}

class ArrayQueue {
    private int[] myQueue;
    private int head;//队头指向当前队头
    private int tail;//对尾指向队尾的下一个
    private int maxSize;

    public ArrayQueue(int size) {
        this.maxSize = size + 1;
        myQueue = new int[this.maxSize];//始终有一个空的
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return tail == head;

    }

    public boolean isFull() {
        return (tail + 1) % this.maxSize == head;
    }

    public void enQueue(int n) {
        if (isFull()) {
            System.out.println("队列满 不能入队");
            return;
        }

        myQueue[tail] = n;
        tail = (tail + 1) % this.maxSize;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("队列为空不能出队");
            return -1;
        }

        int rest = myQueue[head];
        head = (head + 1) % this.maxSize;


        return rest;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("队列为空不能打印");
            return -1;
        }
        return myQueue[head];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空不能打印");
            return;
        }
//        int end = head < tail ? tail : tail + this.maxSize;
//        for (int i = head ; i < end; i++) {
//            System.out.print(myQueue[i % this.maxSize] + " ");
//        }

        for (int i = head; i < (head + size()); i++) {
            System.out.print(myQueue[i % this.maxSize] + " ");
        }

        System.out.println();
    }
    
    public int size(){
        return (tail+this.maxSize-head)%this.maxSize;
    }

}
