package com.bytedance.observer;

import java.util.Observable;
import java.util.Observer;

public class OneClient implements Observer {
    private int d1;
    private int d2;

    @Override
    public void update(Observable o, Object arg) {
        Server.Data data = (Server.Data) arg;

        this.d1 = data.d1;
        this.d2 = data.d2;

        display();

    }

    public void display() {
        System.out.println("one d1=" + this.d1 + " d2=" + this.d2);
    }
}
