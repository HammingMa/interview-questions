package com.mzh.singleton;

public class SingletonDemo {

    private volatile static  SingletonDemo singleton;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() +" 我是构造方法");
    }


    public synchronized static SingletonDemo getInstance() {
        if (singleton == null) {
            singleton = new SingletonDemo();
        }

        return singleton;
    }

    //DCL Double Check Lock 双端检锁机制 由于指令重排可能 出现某次对象为空
    public  static SingletonDemo getInstance2() {
        if (singleton == null) {
            synchronized(SingletonDemo.class) {
                if(singleton ==null) {
                    singleton = new SingletonDemo();
                }
            }
        }

        return singleton;
    }


    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                SingletonDemo.getInstance2();
            },String.valueOf(i)).start();
        }
    }
}
