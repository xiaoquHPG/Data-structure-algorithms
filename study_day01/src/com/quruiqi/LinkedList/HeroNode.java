package com.quruiqi.LinkedList;

/**
 * @Author Lenovo
 * @Date 2023/8/31 16:13
 **/
public class HeroNode {

    int num;
    private String name;
    private String nickName;
    HeroNode nextNode;

    HeroNode(int num, String name, String nickName){
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
