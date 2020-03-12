package com.bytedance;

import java.util.Arrays;

public class ChangeSymbolDemo {

    //一个数组，让把数组变成相邻元素的符号不同，比如1，-1，1，1，-1，-1，-1，1要变成1，-1，1，-1，1，-1，1，-1

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 1, 1, -1, -1, -1, 1};
        changeSymbol2(array);

        System.out.println(Arrays.toString(array));
    }

    public static void changeSymbol(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            if ((array[i] > 0 && array[i + 1] > 0) || (array[i] < 0 && array[i + 1] < 0)) {
                array[i + 1] = (-array[i + 1]);
            }

        }
    }

    public static void changeSymbol2(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] * array[i + 1] > 0) {
                array[i + 1] = (-array[i + 1]);
            }

        }
    }

}
