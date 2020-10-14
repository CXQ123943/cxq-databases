package com.cxq.datastructures.sort;

import java.util.Arrays;

/**
 * @author CXQ
 * @version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {39, -1, 35, 86, -6, -65, 32, 0, 93, 144};
        System.out.println("原数组...");
        System.out.println(Arrays.toString(arr));
        selectSortDemo(arr);
        System.out.println("排列后数组...");
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSortDemo(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //定义一个最小值的角标
            int minIndex = i;
            //定义数组第一位就是最小值
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            /*
             * 判断最小值的角标是否为当前位置
             * */
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
