package com.leetcode.offer;

public class Fib {

    /*
        写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
        斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

     */
    public static void main(String[] args) {

        System.out.println(fib(47));
        System.out.println(fib2(47));

    }

    public static long fib(int n) {

        if (n <= 1) {
            return n;
        } else {
            return (fib(n - 1) + fib(n - 2))%1000000007;
        }

    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        int fibOne = 0;
        int fibtwo = 1;

        int rest = -1;
        for (int i = 2; i <= n; i++) {
            rest = (fibOne + fibtwo)%1000000007;
            fibOne = fibtwo;
            fibtwo = rest;
        }

        return rest;

    }
}

