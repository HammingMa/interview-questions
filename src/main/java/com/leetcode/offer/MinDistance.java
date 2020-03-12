package com.leetcode.offer;

import java.util.Arrays;

public class MinDistance {

    /*
        给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

        你可以对一个单词进行如下三种操作：

        插入一个字符
        删除一个字符
        替换一个字符
        示例 1:

        输入: word1 = "horse", word2 = "ros"
        输出: 3
        解释:
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')
        示例 2:

        输入: word1 = "intention", word2 = "execution"
        输出: 5
        解释:
        intention -> inention (删除 't')
        inention -> enention (将 'i' 替换为 'e')
        enention -> exention (将 'n' 替换为 'x')
        exention -> exection (将 'n' 替换为 'c')
        exection -> execution (插入 'u')

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/edit-distance
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "hos"));

        int[][] array1 = new int[4][4];
        int[][] array2 = new int[4][4];


    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;

        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }


        char ch1;
        char ch2;
        int left;
        int up;
        int leftUp;
        for (int i = 1; i <= m; i++) {
            ch1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                ch2 = word2.charAt(j - 1);
                left = dp[i][j - 1] + 1;
                up = dp[i - 1][j] + 1;
                leftUp = dp[i - 1][j - 1];
                if (ch1 != ch2) {
                    leftUp++;
                }

                dp[i][j] = Math.min(leftUp, Math.min(left, up));

            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }


        return dp[m][n];

    }
}
