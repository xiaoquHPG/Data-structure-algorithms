package com.quruiqi.tree;

/**
 * @Author Lenovo
 * @Date 2023/9/4 21:18
 **/
public class ThreadedHeroNode {

    int no;
    String name;
    ThreadedHeroNode left;
    ThreadedHeroNode right;
    int leftType;
    int rightType;
    ThreadedHeroNode parent;

    ThreadedHeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadedHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }
}
