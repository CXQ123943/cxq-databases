package com.cxq.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author CXQ
 * @version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        /*// 创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }*/

        System.out.println("原数组...");
        System.out.println(Arrays.toString(arr));
        /*Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);*/

        insertSort(arr);

       /* Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);*/

        System.out.println("排序后数组...");
        System.out.println(Arrays.toString(arr));
    }


    //插入排序
    private static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            // 即arr[1]的前面这个数的下标
            insertIndex = i - 1;

            //insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //数组后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //插入的位置找到, insertIndex + 1
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
