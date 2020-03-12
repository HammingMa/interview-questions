package com.bytedance;

import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 2, 7, 1, 4, 9, 8, 0};

        int[] helpArray = new int[array.length];
        mergeSort(array, 0, array.length - 1, helpArray);

        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int startIndex, int endIndex, int[] helpArray) {


        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;

            mergeSort(array, startIndex, mid, helpArray);
            mergeSort(array, mid + 1, endIndex, helpArray);

            merge(array, startIndex, mid, mid + 1, endIndex, helpArray);
        }
    }

    public static void merge(int[] array, int index1, int endIndex1, int index2, int endIndex2, int[] helpArray) {

        int i1 = index1;
        int i2 = index2;
        int helpIndex = index1;

        while (i1 <= endIndex1 && i2 <= endIndex2) {

            if (array[i1] < array[i2]) {
                helpArray[helpIndex] = array[i1];
                i1++;

            } else {
                helpArray[helpIndex] = array[i2];
                i2++;
            }
            helpIndex++;
        }

        while (i1 <= endIndex1) {
            helpArray[helpIndex] = array[i1];
            helpIndex++;
            i1++;
        }

        while (i2 <= endIndex2) {
            helpArray[helpIndex] = array[i2];
            helpIndex++;
            i2++;
        }

        for (int i = index1; i < helpIndex; i++) {
            array[i] = helpArray[i];
            System.out.print(helpArray[i] + " ");
        }
        System.out.println();

    }

}
