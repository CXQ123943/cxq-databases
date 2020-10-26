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


        //前序遍历查找
        System.out.println("前序遍历方式...");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}

        /*//中序遍历查找
		System.out.println("中序遍历方式~~~");
		HeroNode resNode = binaryTree.infixOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}

        //后序遍历查找
		System.out.println("后序遍历方式~~~");
		HeroNode resNode = binaryTree.postOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}*/
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

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
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

    /**
     * 前序查找
     * @param no 需要查找的节点的序号
     * @return 返回查找到的节点
     * */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        //比较当前结点是不是
        if(this.no == no) {
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null) {
            //说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序查找
     * @param no 需要查找的节点的序号
     * @return 返回查找到的节点
     * */
    public HeroNode infixOrderSearch(int no) {
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if(this.no == no) {
            return this;
        }
        //否则继续进行右递归的中序查找
        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    /**
     * 后序查找
     * @param no 需要查找的节点的序号
     * @return 返回查找到的节点
     * */
    public HeroNode postOrderSearch(int no) {

        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null) {
            //说明在左子树找到
            return resNode;
        }

        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前结点是不是
        if(this.no == no) {
            return this;
        }
        return resNode;
    }
}