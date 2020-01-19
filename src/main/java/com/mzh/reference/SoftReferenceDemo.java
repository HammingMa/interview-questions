package com.mzh.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static void softReferenceMemoryEnough(){
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(s1.get());

        o1=null;
        System.gc();

        System.out.println(o1);
        System.out.println(s1.get());

    }

    public static void softReferenceMemoryNotEnough(){

        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(s1.get());

        o1=null;

        try{
            byte[] b = new byte[30*1024*1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(s1.get());
        }

    }

    public static void main(String[] args) {
        softReferenceMemoryEnough();

        System.out.println();
        System.out.println();
        softReferenceMemoryNotEnough();
    }
}
