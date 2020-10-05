package com.cxq.datastructures.linklist;

import org.junit.Before;
import org.junit.Test;

/**
 * @author CXQ
 * @version 1.0
 */
public class SingleLinkedListTest {

    private static class SingleLinkedListDemo<E> {

        //设计一个head(链表头)，一个tail（链表尾），一个size（链表长度）
        private Node<E> head;

        //构造方法 链表的创建
        private SingleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
        }

        //创建了一个节点类
        private static class Node<E> {
            //设计节点的两个属性：data（数据域），next（后继指针域）。
            E data;
            Node<E> next;

            Node(E data) {
                this.data = data;
            }

            //重写了节点类的toString（）方法
            @Override
            public String toString() {
                return "[" + data + "-> " + (next == null ? "null" : next.data) + "]";
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            //创建一个数据域的副本
            Node<E> current = head;
            //遍历所有的节点，要是数据域为null，跳出循环
            while (current != null) {
                stringBuilder.append("[");
                stringBuilder.append(current.data);
                stringBuilder.append("-> ");
                stringBuilder.append(current.next == null ? "null" : current.next.data);
                stringBuilder.append("] ");
                current = current.next;
            }
            return stringBuilder.toString();
        }

        private SingleLinkedListDemo resetHead(E data) {
            //创建了一个新的节点，并重新设计新节点的data和next
            Node<E> newNode = new Node<>(data);
            newNode.next = this.head;
            //新的节点头就是newHead  重新定义head属性
            this.head = newNode;
            return this;
        }

        private SingleLinkedListDemo<E> add(E data) {
            // 创建一个新节点，追加到链表的末端
            Node<E> backup = head;
            while (backup.next != null) {
                backup = backup.next;
            }
            backup.next = new Node<E>(data);
            return this;
        }


        private SingleLinkedListDemo<E> add(E data, int pos) {
            // 创建一个新节点，追加到链表的指定位置
            if (pos <= 0) {
                this.resetHead(data);
                return this;
            }

            Node<E> newNode = new Node<>(data);
            Node<E> currentNode = this.head;
            Node<E> preNode = this.head;
            for (int i = 0; i < pos; i++) {
                if (currentNode.next == null) {
                    add(data);
                    return this;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            preNode.next = newNode;
            newNode.next = currentNode;
            return this;
        }

        private Node<E> get(E data) {
            // 获取指定data内容的Node节点
            Node<E> currentNode = this.head;
            Node<E> result = null;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            }
            return result;
        }

        private SingleLinkedListDemo<E> delete(E data) {
            // 删除指定data内容的Node节点（头节点忽略）
            Node<E> currentNode = this.head;
            Node<E> PreNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    PreNode.next = currentNode.next;
                    break;
                }
                PreNode = currentNode;
                currentNode = currentNode.next;
            }
            return this;
        }
    }

    private SingleLinkedListDemo<String> linkList;

    @Before
    public void before() {
        linkList = new SingleLinkedListDemo<>("1111");
    }

    @Test
    public void addHead() {
        System.out.println(linkList.resetHead("2222"));
        System.out.println(linkList.resetHead("3333"));
        System.out.println("此时的链表为：" + linkList);
    }

    @Test
    public void add() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
    }

    @Test
    public void addWithPos() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222", 0));
        System.out.println(linkList.add("3333", 9));
        System.out.println(linkList.add("4444", 1));
        System.out.println(linkList.add("5555", 2));
    }

    @Test
    public void get() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222", 9));
        System.out.println(linkList.add("3333", 0));
        System.out.println("node: " + linkList.get("2222"));
        System.out.println("node: " + linkList.get("3333"));
        System.out.println("node: " + linkList.get("4444"));
    }

    @Test
    public void delete() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
        System.out.println(linkList.delete("2222"));
        System.out.println(linkList.delete("5555"));
    }
}