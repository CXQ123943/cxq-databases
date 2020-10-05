package com.cxq.datastructures.queue;

/**
 * @author CXQ
 * @version 1.0
 */
public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println(arrayQueue.isEmpty() ? "为空" : "不为空");
        arrayQueue.addQueue(8);
        arrayQueue.addQueue(5);
        System.out.println(arrayQueue.isEmpty() ? "为空" : "不为空");
        System.out.println(arrayQueue.isFull() ? "为满" : "不为满");
        arrayQueue.showQueue();
    }
}

/**
 * ArrayQueue类
 */
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arrayQueue;

    /**
     * 数组队列的构造器
     */
    ArrayQueue(int maxSize) {
        //预留一个空的元素
        this.maxSize = maxSize + 1;
        arrayQueue = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否为空
     */
    boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否为满
     */
    boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    /**
     * 添加数据到队列
     */
    void addQueue(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满...");
        } else {
            arrayQueue[rear] = value;
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * 获取队列数据
     */
    int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不可以取出元素");
        } else {
            front++;
            return arrayQueue[front];
        }
    }

    /**
     * 显示队列
     */
    void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (front != rear) {
                stringBuilder.append(arrayQueue[front]);
                front = (front + 1) % maxSize;
            }
            System.out.println("Queue[" + stringBuilder + "]");
        }
    }
}

