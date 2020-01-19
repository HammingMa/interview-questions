package com.mzh.oom;

public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlowError();
    }

    public static void stackOverFlowError() {
        stackOverFlowError();
    }
}
