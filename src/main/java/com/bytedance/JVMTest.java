package com.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JVMTest {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(args));
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (true) {
            list.add(i);
            i++;
            System.out.println(123);
            //TimeUnit.SECONDS.sleep(1);
        }
    }
}
