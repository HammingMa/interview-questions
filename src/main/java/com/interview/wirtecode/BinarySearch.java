package com.interview.wirtecode;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int value = 5;

        int index = binarySearch(arr, value);
        System.out.println(index);

        index = binarySearch2(arr, value, 0, arr.length - 1);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int value) {
        int rest = -1;

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] == value) {
                rest = mid;
                break;
            }
        }


        return rest;
    }

    public static int binarySearch2(int[] arr, int value, int low, int high) {
        int rest = -1;
        if (low > high) {
            return rest;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == value) {
            rest = mid;
        } else if (arr[mid] < value) {
            rest = binarySearch2(arr, value, mid + 1, high);
        } else if (arr[mid] > value) {
            rest = binarySearch2(arr, value, low, mid - 1);
        }
        return rest;
    }
}
