package com.quruiqi.tree;

/**
 * 平衡二叉树
 * @Author Bill
 * @Date 2023/9/6 10:45
 **/
public class BalanceBinaryTree {

    BalanceBinaryNode root;

    //添加
    public void add(BalanceBinaryNode add){
        if (root == null){
            root = add;
            return;
        }
        root.add(add);
    }

    //中序遍历
    public void midOrder(){
        root.midOrder();
    }

    //获取高度
    public int height(){
        return root.height();
    }

    //获取左高
    public int leftHeight(){
        return root.leftHeight();
    }

    //获取右高
    public int rightHeight(){
        return root.rightHeight();
    }

}
