package com.quruiqi.tree;

/**
 * @Author Bill
 * @Date 2023/9/6 13:57
 **/
public class BalanceBinaryTreeDemo {

    public static void main(String[] args) {
        // int[] arr ={4,3,6,5,7,8};
        int[] arr = { 10, 12, 8, 9, 7, 6 };
        BalanceBinaryTree tree = new BalanceBinaryTree();
        for (int i:arr) {
            BalanceBinaryNode node = new BalanceBinaryNode(i);
            tree.add(node);
        }
        tree.midOrder();

        System.out.println("AVL树高度：" +tree.height());
        System.out.println("left高度：" +tree.root.leftHeight());
        System.out.println("right高度：" +tree.root.rightHeight());
    }

}
