package com.mzh.oom;

import java.util.Random;

public class OutOfMemoryErrorDemo {
    public static void main(String[] args) {
        String str = new String("test");

        while (true) {
            str += str + new Random().nextInt(1111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }
}
