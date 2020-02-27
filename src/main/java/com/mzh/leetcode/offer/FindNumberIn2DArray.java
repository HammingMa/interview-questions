package com.mzh.leetcode.offer;

public class FindNumberIn2DArray {
    /*
        在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
        示例:

        现有矩阵 matrix 如下：

        [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]
        给定 target = 5，返回 true。

        给定 target = 20，返回 false。

        限制：

        0 <= n <= 1000

        0 <= m <= 1000

     */

    public static void main(String[] args) {
        int[][] nums = new int[][]
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}

                };
        for (int[] num : nums) {
            for (int i : num) {
                System.out.println(findNumberIn2DArray(nums, i));
            }
        }

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean rest = false;
        if (matrix == null || matrix.length == 0) {
            return rest;
        }


        int left = 0;
        int rigth = matrix[0].length - 1;

        int mid;

        int i = 0;

        while (left <= rigth && i<matrix.length) {

            mid = (left + rigth) / 2;

            System.out.println(left+" "+mid+" "+rigth);

            if (matrix[i][mid] == target) {
                rest = true;
                break;
            } else if (matrix[i][mid] > target) {
                if (left > mid - 1) {
                    i++;
                    left = 0;
                } else {
                    rigth = mid - 1;
                }
            } else if (matrix[i][mid] < target) {
                if (mid + 1 > rigth) {
                    i++;
                    left = 0;
                } else {
                    left = mid + 1;
                }
            }

        }

        return rest;

    }
}
