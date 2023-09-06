package com.quruiqi.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 * @Author Bill
 * @Date 2023/9/5 19:27
 **/
public class HuffmanTree {

    public static HuffmanTreeNode huffmanTree(int[] data){

            List<HuffmanTreeNode> list = new ArrayList<>();
        for (int datum : data) {
            list.add(new HuffmanTreeNode(datum));
        }

        Collections.sort(list);

        while (list.size() > 1){

            HuffmanTreeNode left = list.get(0);
            HuffmanTreeNode right = list.get(1);

            HuffmanTreeNode node = new HuffmanTreeNode(left.value + right.value);
            node.left = left;
            node.right = right;

            list.remove(left);
            list.remove(right);
            list.add(node);
            //记住重新给数组排序下
            Collections.sort(list);
        }

        return list.get(0);
    }

    public static void main(String[] args) {

        int[] arr = {13,7,8,3,29,6,1};
        System.out.println("前序输出结果：");
        preOrder(huffmanTree(arr));

    }

    //先序遍历
    private static void preOrder(HuffmanTreeNode huffmanTree) {

        if (huffmanTree == null){
            return;
        }

        System.out.printf("%d\t", huffmanTree.value);
        if (huffmanTree.left != null){
            preOrder(huffmanTree.left);
        }

        if (huffmanTree.right != null){
            preOrder(huffmanTree.right);
        }

    }

}
