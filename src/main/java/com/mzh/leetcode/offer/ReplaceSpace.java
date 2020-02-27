package com.mzh.leetcode.offer;

public class ReplaceSpace {
    /*
        请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

        示例 1：

        输入：s = "We are happy."
        输出："We%20are%20happy."
         

        限制：

        0 <= s 的长度 <= 10000
     */
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        String rest = null;

        char[] chars = new char[s.length() * 3];

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[index] = '%';
                chars[index + 1] = '2';
                chars[index + 2] = '0';
                index += 3;
            } else {
                chars[index] = s.charAt(i);
                index++;
            }
        }
        rest = new String(chars, 0, index);
        return rest;
    }
}
