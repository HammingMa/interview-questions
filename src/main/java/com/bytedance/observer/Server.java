package com.bytedance.observer;

import java.util.Observable;

public class Server extends Observable {


    public void changeData(int d1, int d2) {
        Data data = new Data(d1, d2);
        setChanged();
        this.notifyObservers(data);
    }

    public class Data {
        public int d1;
        public int d2;

        public Data(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }
    }
}
