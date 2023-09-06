package com.quruiqi.tree;

/**
 * 哈夫曼树 节点
 * @Author Bill
 * @Date 2023/9/5 19:20
 **/
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {

    int value;
    HuffmanTreeNode left;
    HuffmanTreeNode right;

    HuffmanTreeNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        //从小到大
        return this.value - o.value;
    }
}
