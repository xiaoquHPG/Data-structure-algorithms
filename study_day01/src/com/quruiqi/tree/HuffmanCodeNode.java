package com.quruiqi.tree;

/**
 * 哈夫曼编码节点
 * @Author Bill
 * @Date 2023/9/5 21:03
 **/
public class HuffmanCodeNode implements Comparable<HuffmanCodeNode>{

    Byte data;
    int weight;
    HuffmanCodeNode left;
    HuffmanCodeNode right;

    HuffmanCodeNode(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(HuffmanCodeNode node){

        if (node == null){
            return;
        }

        System.out.println(node);

        if (node.left != null){
            preOrder(node.left);
        }

        if (node.right != null){
            preOrder(node.right);
        }

    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;
    }
}
