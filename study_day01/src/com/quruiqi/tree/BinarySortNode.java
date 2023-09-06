package com.quruiqi.tree;

/**
 * 二叉排序树节点
 * @Author Bill
 * @Date 2023/9/6 8:12
 **/
public class BinarySortNode {

    int value;
    BinarySortNode left;
    BinarySortNode right;

    BinarySortNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" +
                "value=" + value +
                '}';
    }

    //添加二叉树节点
    public void add(BinarySortNode add) {

        if (this.value > add.value){
            if (this.left != null){
                this.left.add(add);
            }else{
                this.left = add;
            }
        }else{
            if (this.right != null){
                this.right.add(add);
            }else{
                this.right = add;
            }
        }
    }

    //中序遍历
    public void midOrder(){

        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder(){

        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);

    }

    //删除节点
    public void delete(int no){

        boolean flag = false;
        if (this.value > no){
            if (this.left != null && this.left.value == no){
                //判断该节点是叶子节点 还是非叶子节点 如果有节点是一个还是两个
                handle(this,this.left,!flag);
            }else if (this.left != null && this.left.value != no){
                this.left.delete(no);
            }
        }else{
            if (this.right != null && this.right.value == no){
                handle(this,this.right,flag);
            }else if (this.right != null && this.right.value != no){
                this.right.delete(no);
            }
        }


    }

    //如果当前节点命中了 就需要处理该节点
    private void handle(BinarySortNode pre, BinarySortNode node, boolean flag){
        if (node.left == null && node.right == null){
            if (flag){
                pre.left = null;
            }else{
                pre.right = null;
            }
            return;
        }

        if (node.left != null && node.right == null){
            //替换节点
            if (flag){
                pre.left = node.left;
            }else{
                pre.right = node.left;
            }
            return;
        }

        if (node.right != null && node.left == null){
            if (flag){
                pre.left = node.right;
            }else{
                pre.right = node.right;
            }
            return;
        }

        //如果两个节点都是空的我们找到右子树的最小节点 替换pre节点
        if (node.left != null && node.right != null){
            int min = findRightNodeMinValue(node);
            node.value = min;
            return;
        }
    }

    private int findRightNodeMinValue(BinarySortNode node) {

        BinarySortNode cur = node.right;
        while (cur.left != null){
            cur = cur.left;
        }
        delete(cur.value);

        return cur.value;


    }

}
