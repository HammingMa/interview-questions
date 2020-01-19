package com.mzh.oom;

import java.util.ArrayList;
import java.util.List;

public class GCOverHeadDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        System.out.println(String.valueOf(i).intern());

        try {

            while (true) {
                list.add(String.valueOf(++i).intern());
            }

        } catch (Throwable e) {
            System.out.println("=======================");
            System.out.println(i);
            e.printStackTrace();
            throw e;
        }

    }
}
