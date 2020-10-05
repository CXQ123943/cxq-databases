package com.cxq.datastructures.stack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author CXQ
 * @version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}

/**
 * 定义一个ArrayStack类
 */
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈（push）
     *
     * @param value 要入栈的值
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
        } else {
            top++;
            stack[top] = value;
        }
    }

    //出栈
    public int pop() {
        int value;
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        } else {
            value = stack[top];
            top--;
        }
        return value;
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空，无法遍历");
        }
        System.out.println(Arrays.toString(stack));
    }
}
