package com.interview.wirtecode;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 8, 9, 2, 1, 4, 7, 6};

        bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = true;
        for (int i = arr.length - 1; i > 0; i--) {
            flag=true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }

            for (int i1 : arr) {
                System.out.print(i1+" ");
            }
            System.out.println();

            if(flag){
                break;
            }
        }
    }
}
