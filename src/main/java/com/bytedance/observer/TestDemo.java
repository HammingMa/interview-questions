package com.bytedance.observer;

public class TestDemo {
    public static void main(String[] args) {
        Server s1 = new Server();
        OneClient one = new OneClient();
        TwoClient two = new TwoClient();

        s1.addObserver(one);
        s1.addObserver(two);

        s1.changeData(10,20);

        s1.deleteObserver(two);

        s1.changeData(50,60);

    }
}
