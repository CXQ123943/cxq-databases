package com.cxq.datastructures.array;

import java.io.*;

/**
 * @author CXQ
 * @version 1.0
 */
public class SparseArray {

    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        int[][] originalArray = new int[11][11];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;
        int sum = 0;

        System.out.println("原数组：");
        traversalArray(originalArray);

        System.out.println("数组中的有效元素个数为：" + effectiveElement(originalArray));

        System.out.println("稀疏数组：");
        int[][] sparseArray = convertArray(originalArray);
        traversalArray(sparseArray);

        writerArray(originalArray);

        int[][] finallyArray = restoretArray(sparseArray);
        traversalArray(finallyArray);

        //IO流的方式
        finallyArray = readAndConversionArray();
        traversalArray(finallyArray);
    }

    /**
     * 遍历数组并输出
     */
    private static void traversalArray(int[][] array) {
        for (int[] row : array) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    /**
     * 获得原数组的有效元素个数
     */
    private static int effectiveElement(int[][] array) {
        for (int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 将原数组转换成稀疏数组
     */
    private static int[][] convertArray(int[][] originalArray) {
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originalArray[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originalArray[i][j];
                    count++;
                }
            }
        }


        return sparseArray;
    }

    /**
     * 将稀疏组转换成原数组
     *
     * @param sparseArray 稀疏数组
     */
    private static int[][] restoretArray(int[][] sparseArray) {
        int[][] finallyArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            finallyArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("从稀疏数组转换为原数组：");
        return finallyArray;
    }

    /**
     * 把得到稀疏数组放到硬盘中的指定文件夹中
     *
     * @param originalArray 原始数组
     */
    private static void writerArray(int[][] originalArray) {
        String filePath = "D:" + File.separator + "idea2018" + File.separator + "idea" + File.separator + "sparseArray.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int[][] sparseArray = convertArray(originalArray);
            for (int[] row : sparseArray) {
                for (int data : row) {
                    String str;
                    str = data + " ";
                    bufferedWriter.write(str);
                }
                bufferedWriter.write("\n");
            }
            System.out.println("write over,result is:");
            bufferedWriter.flush();

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中获得稀疏数组并转换成原数组
     */
    private static int[][] readAndConversionArray() throws IOException {
        String filePath = "D:" + File.separator + "idea2018" + File.separator + "idea" + File.separator + "sparseArray.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //用于确定新建的二维数组的大小
        int row = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            row++;
        }
        //新定义一个稀疏数组（将读取到的数据放到这个新的数组中）
        int[][] sparseArray = new int[row][3];
        int rowtemp = 0;
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filePath));
        while ((line = bufferedReader.readLine()) != null) {
            //分割字符串 放到一个字符串数组中
            String[] tempArray = line.split(" ");
            for (int j = 0; j < tempArray.length; j++) {
                sparseArray[rowtemp][j] = Integer.parseInt(tempArray[j]);
            }
            rowtemp++;
        }
        bufferedReader.close();
        restoretArray(sparseArray);
        return restoretArray(sparseArray);
    }
}