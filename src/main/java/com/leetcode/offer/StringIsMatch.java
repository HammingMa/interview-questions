package com.leetcode.offer;

public class StringIsMatch {

    /*
            请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

            示例 1:

            输入:
            s = "aa"
            p = "a"
            输出: false
            解释: "a" 无法匹配 "aa" 整个字符串。
            示例 2:

            输入:
            s = "aa"
            p = "a*"
            输出: true
            解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
            示例 3:

            输入:
            s = "ab"
            p = ".*"
            输出: true
            解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
            示例 4:

            输入:
            s = "aab"
            p = "c*a*b"
            输出: true
            解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
            示例 5:

            输入:
            s = "mississippi"
            p = "mis*is*p*."
            输出: false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

        boolean b = true || false;
        boolean b2 = b && false;
        System.out.println(b2);

        System.out.println(true || false && false);
        if (true || false && false) {
            System.out.println(123);
            System.out.println(true || false && false);
        }

        System.out.println(true && false);

//        String s = "a";
//        String p = "..*";

//        String s = "aaa";
//        String p = "ab*a*c*a";
//
//        String s = "mississippi";
//        String p = "mis*is*ip*.";

//        String s = "aa";
//        String p = "a";

        String s = "aab";
        String p = "b.*";


        System.out.println(isMatch3(s, p));

    }


    public static boolean isMatch3(String s, String p) {

        if (s == p || s.equals(p)) {
            return true;
        }

        if (p.isEmpty()) {
            return false;
        }


        if (".*".equals(p)) {
            return true;
        }


        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        //两个都是空串是包含的
        dp[0][0] = true;
        //s不为空p为空是匹配不上的 初始化第一列
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        //初始化第一行 s为空p不为空的匹配条件结果
        dp[0][1] = false; //第0号第1列，代表 s为空 p为1个字符串，肯定匹配不上
        for (int i = 2; i < dp[0].length; i++) {
            // p为 x*x*x*x*的情况匹配空串 才可以匹配上
            // 规律就是 不是*号肯定匹配不到空的s 当前为*号就取前面隔着一位的值 -2 ，
            // 只有前面 隔着一位 配上了 空的 s ，当前的* 才能匹配上空串s
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];

        }

        int sIndex = 0;
        int pIndex = 0;
        //循环动态规划矩阵 列
        for (int i = 1; i < dp.length; i++) {
            sIndex = i - 1;
            //循环动态规划矩阵 行
            for (int j = 1; j < dp[0].length; j++) {
                pIndex = j - 1;
                if (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) {
                    //可以匹配上的情况
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(pIndex) == '*') {
                    // j-2 如果当前不取 不使用前一位的字符串
                    // 前一位为 . 或者 前一位的字符和当前的 s的字符相等
                    // 因为当前为*，则如果 如果上一行 匹配到当前位置 没有匹配上 那么 后面的也匹配不上了，因为*前面的字符可以出现0次
                    dp[i][j] = dp[i][j - 2] || ((p.charAt(pIndex - 1) == '.' || p.charAt(pIndex - 1) == s.charAt(sIndex)) && dp[i - 1][j]);

                } else {
                    dp[i][j] = false;
                }

//                System.out.println(s.substring(0, sIndex + 1));
//                System.out.println(p.substring(0, pIndex + 1));
//                System.out.println(dp[i][j]);
            }
//            System.out.println();
        }

        //输出右下角的值即可
//        for (boolean[] booleans : dp) {
//            for (boolean b : booleans) {
//                System.out.print(b + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
        return dp[s.length()][p.length()];
    }
}
