package com.quruiqi.tree;

/**
 * @Author Bill
 * @Date 2023/9/5 8:05
 **/
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        // 先创建一棵二叉树
        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        // 创建需要的节点
        ThreadedHeroNode root = new ThreadedHeroNode(1,"1");
        ThreadedHeroNode node1 = new ThreadedHeroNode(3,"3");
        ThreadedHeroNode node2 = new ThreadedHeroNode(6,"6");
        ThreadedHeroNode node3 = new ThreadedHeroNode(8,"8");
        ThreadedHeroNode node4 = new ThreadedHeroNode(10,"10");
        ThreadedHeroNode node5 = new ThreadedHeroNode(14,"14");

        root.left = node1;
        root.right = node2;
        node1.parent = root;
        node2.parent = root;
        node1.left = node3;
        node1.right = node4;
        node3.parent = node1;
        node4.parent = node2;
        node2.left = node5;
        node5.parent = node2;
        binaryTree.setRoot(root);

        binaryTree.postOrderThreadedBinaryTree(root);

        ThreadedHeroNode left = node4.left;
        System.out.println("10号的前驱节点： "+left);
        ThreadedHeroNode right = node4.right;
        System.out.println("10号的后继节点： "+right);

//        binaryTree.preOrderSearch(root);
        binaryTree.postOrderSearch(root);
    }

}
