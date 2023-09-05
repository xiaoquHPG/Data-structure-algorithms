package com.quruiqi.tree;

import org.w3c.dom.Node;

/**
 * 线索二叉树
 * @Author Bill
 * @Date 2023/9/4 20:50
 **/
public class ThreadedBinaryTree {

    ThreadedHeroNode root;
    ThreadedHeroNode pre = null;

    void setRoot(ThreadedHeroNode root){
        this.root = root;
    }

    //中序线索二叉树
    public void inOrderThreadedBinaryTree(ThreadedHeroNode node){

        if (node == null){
            return;
        }

        if (node.leftType == 0){
            inOrderThreadedBinaryTree(node.left);
        }

        if (node.left == null){
            node.leftType = 1;
            node.left = pre;
        }

        if (pre != null && pre.right == null){
            pre.rightType = 1;
            pre.right = node;
        }

        pre = node;

        if (node.rightType == 0){
            inOrderThreadedBinaryTree(node.right);
        }

    }

    //中序遍历
    public void inOrderSearch(ThreadedHeroNode node){

        while (node != null){
            while (node.leftType == 0){
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1){
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }

    }

    //先序线索二叉树
    public void preOrderThreadedBinaryTree(ThreadedHeroNode node){

        if (node == null){
            return;
        }

        if (node.left == null){
            node.leftType = 1;
            node.left = pre;
        }

        if (pre != null && pre.right == null){
            pre.rightType = 1;
            pre.right = node;
        }

        pre = node;

        if (node.leftType == 0){
            preOrderThreadedBinaryTree(node.left);
        }

        if (node.rightType == 0){
            preOrderThreadedBinaryTree(node.right);
        }

    }

    //先序遍历
    public void preOrderSearch(ThreadedHeroNode node){


        while (node != null){

            while (node.leftType == 0){
                System.out.println(node);
                node = node.left;
            }
            System.out.println(node);
            node = node.right;
        }

    }

    //后序线索二叉树
    public void postOrderThreadedBinaryTree(ThreadedHeroNode node){

        if (node == null){
            return;
        }

        if (node.leftType == 0){
            postOrderThreadedBinaryTree(node.left);
        }

        if (node.rightType == 0){
            postOrderThreadedBinaryTree(node.right);
        }

        if (node.left == null){
            node.leftType = 1;
            node.left = pre;
        }

        if (pre != null && pre.right == null){
            pre.rightType = 1;
            pre.right = node;
        }

        pre = node;

    }

    //后序遍历  存在问题再改改
    public void postOrderSearch(ThreadedHeroNode node){

        ThreadedHeroNode root = node;
        while (node != null){

            while (node.leftType == 0){
                node = node.left;
            }


            while (node != null && node.rightType == 1){
                System.out.println(node);
                pre = node;
                node = node.right;
            }

            if (node == root){
                System.out.println(node);
                return;
            }
            //这里他最终 要到根节点
            while (node != null && node.right == pre){
                System.out.println(node);
                pre = node;
                node = node.parent;
            }
            //再走一轮
            if (node != null && node.rightType == 0){
                node = node.right;
            }
        }

    }

}
