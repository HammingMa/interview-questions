package com.bytedance;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 2, 7, 1, 4, 9, 8, 0};

        heapSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {

        //array.length / 2 - 1 为第一个 非叶子节点
        //从第一个非叶子节点开始依次循环调整为大顶堆
        //调整完成之后 所有的数据组成一个大顶堆
        // i-- 向数组的前面走 全是非叶子节点
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            //将调整好的大顶堆的顶 放到 需要排序的 最后
            // 将顶换成叶子节点
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //从顶开始调整，重新调整为大顶堆
            adjustHeap(array, 0, i);
        }
    }

    /**
     * @param array  要排序的数组
     * @param index  需要排序的大顶堆的顶，第一个非叶子节点开始 调整为大顶堆 length/2-1
     * @param length 要排序的数组长度
     */
    public static void adjustHeap(int[] array, int index, int length) {

        int temp = array[index];

        //ndex * 2 + 1 index为要调整的非叶子节点 大顶堆的顶 index * 2 + 1 为 index的左子节点
        //i = i * 2 + 1  index节点的左子节点的左子节点 如果还有左子节点 依次循环
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            // i + 1 < length 1.防止越界 2.后面的数据已经调整完了 不需要调整
            // array[i] < array[i + 1] 判断index的左子节点 和右子节点 谁大
            if (i + 1 < length && array[i] < array[i + 1]) {
                //右子节点大于左子节点 让i的值等于右子节点的下标，否则为左子节点的下标
                i++;
            }

            // index的左右子节点大的值，赋值给index节点
            if (array[i] > temp) {
                array[index] = array[i];
                //index 记录交换的i值的下标
                // 2个作用
                // 1.如果还有下一次的循环 还是用 index 值 替换下一次循环较大的子点点
                // 2.第一次循环结束或者多次 循环结束 当前index的值 是和 大顶堆的顶 相等的，需要循环结束将 temp 赋值给 index节点
                index = i;
            } else {
                // 可以break的原因有两个
                // 1. 第一次循环调整的话第一个非叶子节点开始的 不可能还有 孩子 还有孩子
                // 2. 如果是第一次 大顶堆 全部调整完成 ，第二次开始调用用的话 是用最后一个叶子节点替换的堆顶，
                //     进入else 说明 对顶 大于 孩子，下面的孩子全部是调整后的 堆，那么这个大顶堆 就 构造完成了
                break;
            }

            // 当前的index 不一定和 传入的index 相等
            // 可能保存的是需要赋值的子节点的下边 因为前面只是将 大于父节点的孩子赋值给了父节点，子节点的值并没还有 改动，需要最终赋值
            if (array[index] != temp) {
                array[index] = temp;
            }
        }

    }

}
