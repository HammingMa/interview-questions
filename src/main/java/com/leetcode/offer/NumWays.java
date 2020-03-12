package com.leetcode.offer;

public class NumWays {

    /*
        一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

        示例 1：

        输入：n = 2
        输出：2
        示例 2：

        输入：n = 7
        输出：21
     */

    public static void main(String[] args) {
        System.out.println(numWays2(7));
    }

    public static int numWays(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n <= 3) {
            return n;
        } else {
            return numWays(n - 1) + numWays(n - 2) % 1000000007;
        }


    }

    public static int numWays2(int n) {
        if (n <= 0) {
            return 1;
        }

        if (n <= 2) {
            return n;
        }

        int fibOne = 1;
        int fibtwo = 2;

        int rest = -1;
        for (int i = 3; i <= n; i++) {
            rest = (fibOne + fibtwo)%1000000007;
            fibOne = fibtwo;
            fibtwo = rest;
        }

        return rest;


    }
}
