package com.quruiqi.LinkedList;

/**
 * @Author Lenovo
 * @Date 2023/8/31 21:21
 **/
public class Boy {

    int no;
    Boy next;

    Boy(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
