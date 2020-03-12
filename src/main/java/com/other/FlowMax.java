package com.other;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class FlowMax {

    // java 8 流式编程区最大值
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(x -> x).summaryStatistics();

        System.out.println(intSummaryStatistics.getMax());
    }
}
