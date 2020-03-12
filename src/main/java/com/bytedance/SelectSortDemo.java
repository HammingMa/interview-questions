package com.bytedance;

import java.util.Arrays;

public class SelectSortDemo {
    // 选择排序
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 2, 7, 1, 4, 9, 8, 0};

        selectSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array) {
        int maxIndex;

        for (int i = array.length - 1; i >= 0; i--) {
            maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int tmp = array[maxIndex];
                array[maxIndex] = array[i];
                array[i] = tmp;
            }
        }


    }
}
