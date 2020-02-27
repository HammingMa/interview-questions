package com.interview.wirtecode;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 8, 9, 7, 2, 1, 0, 4, 6};

        mergeSort(arr,0,arr.length-1,new int[arr.length]);

        System.out.println(Arrays.toString(arr));

    }


    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid + 1, high, temp);

            merge(arr, low, high, mid, temp);
        }
    }

    private static void merge(int[] arr, int low, int high, int mid, int[] temp) {
        //合并有序数组， low到mid 有序 mid 到 high 有序 合并成意义 完整的有序数组

        int lowIndex = low;
        int highIndex = mid + 1;
        int index = low;

        while (lowIndex <= mid && highIndex <= high) {
            if (arr[lowIndex] < arr[highIndex]) {
                temp[index] = arr[lowIndex];
                lowIndex++;
            } else {
                temp[index] = arr[highIndex];
                highIndex++;
            }
            index++;
        }

        while (lowIndex <= mid) {
            temp[index] = arr[lowIndex];
            index++;
            lowIndex++;
        }

        while (highIndex <= high) {
            temp[index] = arr[highIndex];
            index++;
            highIndex++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }

    }
}
