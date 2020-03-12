package com.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixPrint {
    /*
    [

  [10, 11, 12],

  [23, 24],

  [32, 33]

  ……

]



==>

[

  [10,23,32],

  [10,23,33],

  [10,24,32],

  [10,24,33],

  [11,23,32],

  [11,23,33],

  [11,24,32],

  [11,24,33],

  [12,23,32],

  [12,23,33],

  [12,24,32],

  [12,24,33]

]
    每个数组选一个数 打印所有的组合
     */
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {10, 11, 12},
                {23, 24},
                {32, 33}
        };

        List<int[]> list = matrixPrint(array);

        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }


    }


    public static List<int[]> matrixPrint(int[][] array) {

        List<int[]> restList = new ArrayList<>();

        // 保存每个一维数组的长度
        int[] lenArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            lenArray[i] = array[i].length;
        }

        // 保存每个一维数当前的索引
        int[] indexArray = new int[array.length];

        //保存每个组合的值
        int[] restArray;
        while (indexArray[0] < lenArray[0]) {
            restArray = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                // 每个 一维数组 取一位放到 结果数组中
                restArray[i] = array[i][indexArray[i]];
            }
            //将一组结果 写入到集合中
            restList.add(restArray);

            // 索引数组+1
            indexArray[indexArray.length - 1]++;

            //+1后可能会溢出 需要进位
            for (int i = array.length - 1; i >= 0; i--) {
                //相等需要进位
                if (i > 0 && indexArray[i] == lenArray[i]) {
                    indexArray[i] = 0;
                    indexArray[i - 1]++;
                } else {
                    //不需要进位 终止循环
                    break;
                }
            }


        }


        return restList;
    }
}
