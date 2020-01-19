package com.mzh.jmm;

class Data {
    int number = 0;
    boolean flag = false;

    public void f1() {
        number = 1;
        flag = true;
    }

    public void f2() {
        if (flag) {
            number += 5;
            System.out.println("number vlaue :" +number);
        }
    }
}

public class ReSortCommand {
    public static void main(String[] args) {
        for (int i = 0; i <10000 ; i++) {
            Data data = new Data();



            new Thread(()->{
                data.f1();
            },i+"A").start();

            new Thread(()->{
                data.f2();
            },i+"B").start();

        }

    }
}
