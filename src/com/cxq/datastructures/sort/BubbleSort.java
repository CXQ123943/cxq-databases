package com.cxq.datastructures.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author CXQ
 * @version 1.0
 */
public class BubbleSort {

    @Test
    public void bubbleSortTest() {
        int[] arr = {-8, 5, 45, 9, -4, 5, 17};
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟循环");
            System.out.println(Arrays.toString(arr));
        }

    }

    @Test
    public void optimizeBubbleSortTest() {
        int[] arr = {-8, 5, 45, 9, -4, 5, 17};
        int temp = 0;
        //创建一个标识变量 表示是否进行国变换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    //做了交换，改变表示变量
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟循环");
            System.out.println(Arrays.toString(arr));
            //做判断
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
