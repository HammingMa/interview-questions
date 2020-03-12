package com.leetcode.offer;

public class MyPow {

    /*
        实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

        示例 1:

        输入: 2.00000, 10
        输出: 1024.00000
        示例 2:

        输入: 2.10000, 3
        输出: 9.26100
        示例 3:

        输入: 2.00000, -2
        输出: 0.25000
        解释: 2-2 = 1/22 = 1/4 = 0.25
         

        说明:

        -100.0 < x < 100.0
        n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     */

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            myPow2(2.0, 1020);
        }

        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            myPow3(2.0, 1020);
        }
        long t3 = System.currentTimeMillis();

        System.out.println(t2-t1);
        System.out.println(t3-t3);
    }

    public static double myPow(double x, int n) {
        double rest = 1.0;

        long ln = n;

        if (x == 1) {
            return rest;
        }


        if (n > 0) {
            while (ln > 0) {
                if (ln % 2 == 1) {
                    rest *= x;
                    ln--;
                } else {
                    x *= x;
                    ln /= 2;
                }

            }

        } else {
            ln = -ln;
            while (ln > 0) {

                if (ln % 2 == 1) {
                    rest = rest / x;
                    ln--;
                } else {
                    x *= x;
                    ln /= 2;
                    System.out.println(rest);
                }


            }

        }


        return rest;
    }

    public static double myPow2(double x, int n) {

        switch (n) {
            case 1:
                return x;
            case 0:
                return 1;
            case -1:
                return 1 / x;
            default:
                break;
        }

        double rest = 1;
        double half = myPow2(x, n / 2);
        double mod = 1;
        if (n % 2 == 1) {
            mod = x;
        } else if (n % 2 == -1) {
            mod = 1 / x;
        }
        rest = half * half * mod;


        return rest;

    }

    public static double myPow3(double x, int n) {

        switch (n) {
            case 1:
                return x;
            case 0:
                return 1;
            case -1:
                return 1 / x;
            default:
                break;
        }

        double rest = 1;
        if (n % 4 != 0) {
            double half = myPow2(x, n / 2);
            double mod = 1;
            if (n % 2 == 1) {
                mod = x;
            } else if (n % 2 == -1) {
                mod = 1 / x;
            }
            rest = half * half * mod;
        } else {
            double halt = myPow2(x, n / 4);

            rest = halt * halt * halt * halt;
        }

        return rest;

    }
}
