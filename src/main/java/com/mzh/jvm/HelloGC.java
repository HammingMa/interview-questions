package com.mzh.jvm;

public class HelloGC {
    public static void main(String[] args) {

        //byte[] b = new byte[50*1024*1024];

        System.out.println("Hello GC");

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //git test:
        //git test
        //git update 03
    }
}
