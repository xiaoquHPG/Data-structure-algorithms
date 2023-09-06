package com.quruiqi.tree;

/**
 * 二叉排序树
 * @Author Bill
 * @Date 2023/9/6 8:04
 **/
public class BinarySortTree {

    private BinarySortNode node;

    public BinarySortNode getNode() {
        return node;
    }

    public void setNode(BinarySortNode node) {
        this.node = node;
    }


    //添加节点
    public void add(BinarySortNode add){

        if (node == null){
            node = add;
            return;
        }

        node.add(add);

    }

    //删除节点
    public void delete(int no){

        if (node == null){
            System.out.println("树空");
            return;
        }

        if (node.value == no){
            node = null;
        }else{
            node.delete(no);
        }

    }

    //中序
    public void midOrder(){
        node.midOrder();
    }

    //后续
    public void postOrder(){
        node.postOrder();
    }

}
