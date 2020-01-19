package com.mzh.countdownlatch;


import java.util.concurrent.CountDownLatch;

enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "韩"),
    FIVE(5, "赵"),
    SIX(6, "魏");


    private Integer no;
    private String name;

    public Integer getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    CountryEnum(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    public static CountryEnum getCountry(int no) {
        for (CountryEnum country : CountryEnum.values()) {
            if (country.no == no) {
                return country;
            }
        }

        return null;
    }
}


public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {

        //closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国灭亡");
                countDownLatch.countDown();
            }, CountryEnum.getCountry(i).getName()).start();
        }

        countDownLatch.await();

        System.out.println("秦灭六国，一统天下");

    }

    private static void closeDoor() {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号同学走了");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("班长锁门了");
    }
}
