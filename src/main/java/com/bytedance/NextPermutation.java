package com.bytedance;

import java.util.Arrays;

public class NextPermutation {
    /*
        实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

        必须原地修改，只允许使用额外常数空间。

        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }


            swap(nums, i, j);


        }
        reverse(nums, i + 1);


    }

    public static void reverse(int[] nums, int startIndex) {
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);

            startIndex++;
            endIndex--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
