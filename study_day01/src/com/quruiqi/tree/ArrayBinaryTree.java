package com.quruiqi.tree;

/**
 * 顺序存储二叉树
 * @Author Bill
 * @Date 2023/9/4 19:31
 **/
public class ArrayBinaryTree {

    public static void main(String[] args) {
        ArrayToBinaryTree arrayToBinaryTree = new ArrayToBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        arrayToBinaryTree.preOrder(0);
    }

}
class ArrayToBinaryTree{

    int[] arr;
    ArrayToBinaryTree(int[] data){
        arr = data;
    }

    public void preOrder(int i){

        if (arr.length == 0){
            System.out.println("树空");
            return;
        }

        System.out.printf("%d\t",arr[i]);
        if (2 * i + 1 < arr.length){
            preOrder(2 * i + 1);
        }

        if (2 * i + 2 < arr.length){
            preOrder(2 * i + 2);
        }
    }

}