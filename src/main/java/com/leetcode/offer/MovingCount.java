package com.leetcode.offer;

public class MovingCount {

    /*
        地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

            示例 1：

            输入：m = 2, n = 3, k = 1
            输出：3
            示例 1：

            输入：m = 3, n = 1, k = 0
            输出：1
            提示：

            1 <= n,m <= 100
            0 <= k <= 20
     */

    public static void main(String[] args) {
        System.out.println(movingCount(3, 3, 0));
    }

    public static int movingCount(int m, int n, int k) {


        int[][] array = new int[m][n];


        return movingCount(array, 0, 0, k);
    }

    public static int movingCount(int[][] array, int row, int column, int k) {
        int cnt = 1; //能进入这个格子就算一个
        array[row][column] = 1; //已经进入的将格子值为1

        //向上
        if ((row - 1) >= 0 && array[row - 1][column] != 1 && ((row - 1) % 10 + (row - 1) / 10 + column % 10 + column / 10) <= k) {
            cnt += movingCount(array, row - 1, column, k);
        }
        //向下
        if (row + 1 < array.length && array[row + 1][column] != 1 && ((row + 1) % 10 + (row + 1) / 10 + column % 10 + column / 10) <= k) {
            cnt += movingCount(array, row + 1, column, k);
        }
        //向左
        if (column - 1 >= 0 && array[row][column - 1] != 1 && (row % 10 + row / 10 + (column - 1) % 10 + (column - 1) / 10) <= k) {
            cnt += movingCount(array, row, column - 1, k);
        }
        //向右
        if (column + 1 < array[0].length && array[row][column + 1] != 1 && (row % 10 + row / 10 + (column + 1) % 10 + (column + 1) / 10) <= k) {
            cnt += movingCount(array, row, column + 1, k);
        }


        return cnt;
    }

}
