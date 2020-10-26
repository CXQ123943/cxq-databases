package com.cxq.datastructures.tree;

import lombok.Data;

import java.util.HashMap;

/**
 * @author CXQ
 * @version 1.0
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        HeroNode root = new HeroNode(1,"1");
        HeroNode node2 = new HeroNode(2,"2");
        HeroNode node3 = new HeroNode(3,"3");
        HeroNode node4 = new HeroNode(4,"4");
        HeroNode node5 = new HeroNode(5,"5");
        BinaryTree binaryTree = new BinaryTree(root);

        //手动创建一个二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);

        //binaryTree.preOrder();
        binaryTree.infixOrder();
        binaryTree.postOrder();
    }
}

/**
 * 定义一个BinaryTree 二叉树
 */
@Data
class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }
}

/**
 * 创建HeroNode节点
 */
@Data
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历的方法
     */
    public void preOrder() {
        //先输出root节点
        System.out.println(this);
        //递归 - 左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归 - 右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历的方法
     */
    public void infixOrder() {

        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历的方法
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}