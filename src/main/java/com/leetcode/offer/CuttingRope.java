package com.leetcode.offer;

public class CuttingRope {

    /*
    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

        示例 1：

        输入: 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1
        示例 2:

        输入: 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
        提示：

        2 <= n <= 58
     */
    public static void main(String[] args) {
        System.out.println(cuttingRope(8));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 2) {
            return (int) Math.pow(3, a) * 2;
        } else {
            return (int) Math.pow(3, a - 1) * 4;
        }
    }

    public int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }

        int m = (int) Math.ceil((n > 58 ? 58 : n) / (double) 2);

        int maxValue = 0;

        int avg = 0;
        int value = 0;
        for (int i = 2; i <= m; i++) {
            avg = (int) Math.round(n / (double) i);

            if (n % i == 0) {
                value = (int) Math.pow(avg, i);
            } else {
                value = (int) Math.pow(avg, i - 1) * (n - (avg * (i - 1)));
            }


            if (value > maxValue) {
                System.out.println(i + " " + avg);
                maxValue = value;
            }
        }

        return maxValue;
    }
}
