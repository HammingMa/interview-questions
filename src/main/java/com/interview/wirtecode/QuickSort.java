package com.interview.wirtecode;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 8, 9, 7, 2, 1, 0, 4, 6};

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];

        int l = low;
        int h = high;
        int temp;

        while (l < h) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[h] > pivot) {
                h--;
            }

            //
            if (l >= h) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;

            if (arr[l] == pivot) {
                h--;
            }

            if (arr[h] == pivot) {
                l++;
            }
        }

        System.out.println(l + " " + h);


        if (l == h) {
            l++;
            h--;
        }

        if (low < h) {
            quickSort(arr, low, h);
        }

        if (high > l) {
            quickSort(arr, l, high);
        }


    }
}
