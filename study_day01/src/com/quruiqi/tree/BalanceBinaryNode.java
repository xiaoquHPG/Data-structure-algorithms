package com.quruiqi.tree;

/**
 * 平衡二叉节点
 * @Author Bill
 * @Date 2023/9/6 10:46
 **/
public class BalanceBinaryNode {

    int value;
    BalanceBinaryNode left;
    BalanceBinaryNode right;

    BalanceBinaryNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "BalanceBinaryNode{" +
                "value=" + value +
                '}';
    }

    //左高度
    public int leftHeight(){

        if (this.left == null){
            return 0;
        }

        return this.left.height();
    }

    //右高度
    public int rightHeight(){

        if(this.right == null){
            return 0;
        }

        return this.right.height();

    }


    //获取高度
    public int height() {
        return Math.max((this.left == null?0:this.left.height()),
                (this.right == null?0:this.right.height())) + 1;
    }

    //左旋
    public void leftRotate(){
        //创建一个新子树被左旋过去的子树
        BalanceBinaryNode balanceBinaryNode = new BalanceBinaryNode(this.value);
        //该子树的左边之前结点的左子树
        balanceBinaryNode.left = this.left;
        //右结点则是原结点的小子树（右旋同理 拿大）
        balanceBinaryNode.right = this.right.left;
        //当前新子树构建完毕 当前子树为新根结点
        this.value = this.right.value;
        //连接右子树
        this.right = this.right.right;
        //创建好的新左子树 连接好
        this.left = balanceBinaryNode;
    }

    //右旋
    public void rightRotate(){
        //跟上面是同理的
        BalanceBinaryNode balanceBinaryNode = new BalanceBinaryNode(this.value);
        balanceBinaryNode.right = this.right;
        balanceBinaryNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = balanceBinaryNode;
    }

    //添加节点
    public void add(BalanceBinaryNode node){

        if(node == null){
            return;
        }
        if(this.value>node.value){
            if(this.left != null){
                this.left.add(node);
            }else {
                this.left = node;
            }
        }else{
            if(this.right != null){
                this.right.add(node);
            }else{
                this.right = node;
            }
        }

        //高度差大于1了
        if (Math.abs(this.leftHeight() - this.rightHeight()) > 1){

            if (this.leftHeight() > this.rightHeight()){
                if (this.left != null && this.left.leftHeight() < this.left.rightHeight()){
                    this.left.leftRotate();
                }
                rightRotate();
            }else{
                if (this.right != null && this.right.leftHeight() > this.right.rightHeight()){
                    this.right.rightRotate();
                }
                leftRotate();
            }

        }

    }


    //中序遍历
    public void midOrder() {

        if (this.left != null){
            this.left.midOrder();
        }

        System.out.println(this.value);

        if (this.right != null){
            this.right.midOrder();
        }
    }
}
