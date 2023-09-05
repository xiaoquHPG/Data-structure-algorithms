package com.quruiqi.tree;

/**
 * @Author Bill
 * @Date 2023/9/4 19:09
 **/
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node1 = new HeroNode(2,"吴用");
        HeroNode node2 = new HeroNode(3,"卢俊义");
        HeroNode node3 = new HeroNode(4,"林冲");
        HeroNode node4 = new HeroNode(5,"关胜");
        //创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node4);
        node2.setRight(node3);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.inOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();

        System.out.println("--------前序查找--------------");
        HeroNode preNode = binaryTree.preOrderSearch(5);
        System.out.println("前序查找结果："+preNode);

        System.out.println("--------中序查找--------------");
        HeroNode midNode =  binaryTree.inOrderSearch(5);
        System.out.println("中序查找结果："+midNode);

        System.out.println("--------后序遍历--------------");
        HeroNode backNode =binaryTree.postOrderSearch(5);
        System.out.println("后序查找结果："+backNode);

        System.out.println("删除前 前序遍历: ");
        binaryTree.preOrder();
        binaryTree.delete(3);
        System.out.println("删除后 前序遍历: ");
        binaryTree.preOrder();

    }
}
