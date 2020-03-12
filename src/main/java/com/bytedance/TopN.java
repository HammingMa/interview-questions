package com.bytedance;

import java.util.LinkedList;
import java.util.List;

public class TopN {
    //1亿条数据找出前1000条最大的数据

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 2, 1, 7, 8, 4, 6, 9};
        List<Integer> list = getTopN(array, 4);

        for (Integer num : list) {
            System.out.print(num + " ");
        }

        System.out.println();

    }

    public static List<Integer> getTopN(int[] array, int n) {
        List<Integer> list = new LinkedList<>();

        int i;
        for (int num : array) {

            if (list.size() == n && list.get(0) > num) {
                continue;
            }


            i = 0;
            while (i < list.size() && list.get(i) < num) {
                i++;
            }

            list.add(i, num);

            if (list.size() > n) {
                list.remove(0);
            }
        }

        return list;
    }
}
